package lt.mif.flowershop.service;

import lt.mif.flowershop.dao.FlowerRepository;
import lt.mif.flowershop.domain.MoodDefinition;
import lt.mif.flowershop.domain.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowerService {

    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getSingleFlowers() {
        return flowerRepository.findAllByType(Flower.FlowerType.SINGLE_FLOWER);
    }

    public List<Flower> getBouquets() {
        return flowerRepository.findAllByType(Flower.FlowerType.BOUQUET);
    }

    public List<Flower> getPotFlowers() {
        return flowerRepository.findAllByType(Flower.FlowerType.FLOWER_IN_POT);
    }

    public void createFlower(Flower flower) {
        flowerRepository.save(flower);
    }

    public void updateFlower(Flower flower) {
        flowerRepository.save(flower);
    }

    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }

    public List<Flower> searchFlowers(MoodDefinition moodDefinition) {
        var tags = new HashSet<>(List.of(moodDefinition.getOccasion().toString(), moodDefinition.getAgeGroup().toString(), moodDefinition.getStyle().toString(), moodDefinition.getColorPalette().toString()));
        return flowerRepository.findAll().stream().filter(flower -> flower.getTags().containsAll(tags)).collect(Collectors.toList());
    }

    public Flower getFlower(long flowerId) {
        return flowerRepository.findById(flowerId).get();
    }
}
