package lt.mif.flowershop.lib;

import lt.mif.flowershop.dao.FlowerRepository;
import lt.mif.flowershop.domain.MoodDefinition;
import lt.mif.flowershop.domain.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Component
public class DataPopulator implements CommandLineRunner {

    private final FlowerRepository repository;

    @Autowired
    public DataPopulator(FlowerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws IOException {
        var flowers = List.of(Flower.singleFlower("Rose", "Red", BigInteger.TWO, 10, readImage("rose.jpg"),
                Set.of(
                        MoodDefinition.Style.MINIMALIST.toString(),
                        MoodDefinition.Style.ROMANTIC.toString(),
                        MoodDefinition.AgeGroup.ADULT.toString(),
                        MoodDefinition.AgeGroup.SENIOR.toString(),
                        MoodDefinition.ColorPalette.DEEP.toString(),
                        MoodDefinition.Occasion.CELEBRATION.toString(),
                        MoodDefinition.Occasion.BIRTHDAY.toString()
                )
                ),
                Flower.singleFlower("Tulip", "Purple", BigInteger.valueOf(3), 14, readImage("tulip.jpg"),
                        Set.of(
                                MoodDefinition.Style.MINIMALIST.toString(),
                                MoodDefinition.AgeGroup.ADULT.toString(),
                                MoodDefinition.AgeGroup.SENIOR.toString(),
                                MoodDefinition.AgeGroup.KID.toString(),
                                MoodDefinition.ColorPalette.DEEP.toString(),
                                MoodDefinition.Occasion.CELEBRATION.toString(),
                                MoodDefinition.Occasion.BIRTHDAY.toString()
                        )
                ),
                Flower.bouquet("Bouquet of white roses", List.of("white"), 9, BigInteger.valueOf(10), 5, readImage("white-roses.jpg"),
                        Set.of(
                                MoodDefinition.Style.ROMANTIC.toString(),
                                MoodDefinition.AgeGroup.ADULT.toString(),
                                MoodDefinition.ColorPalette.LIGHT.toString(),
                                MoodDefinition.Occasion.WEDDING.toString()
                        )
                ),
                Flower.bouquet("Funeral bouquet", List.of("white"), 20, BigInteger.valueOf(30), 5, readImage("funeral-bouquet.jpg"),
                        Set.of(
                                MoodDefinition.Style.MINIMALIST.toString(),
                                MoodDefinition.ColorPalette.LIGHT.toString(),
                                MoodDefinition.AgeGroup.KID.toString(),
                                MoodDefinition.AgeGroup.SENIOR.toString(),
                                MoodDefinition.AgeGroup.ADULT.toString(),
                                MoodDefinition.Occasion.FUNERAL.toString()
                        )
                ),
                Flower.potFlower("Cactus", List.of("Green"), 1, BigInteger.valueOf(7), 4, readImage("cactus.jpg"),
                        Set.of(
                                MoodDefinition.Style.COSY.toString(),
                                MoodDefinition.ColorPalette.PASTEL.toString(),
                                MoodDefinition.AgeGroup.KID.toString(),
                                MoodDefinition.AgeGroup.ADULT.toString(),
                                MoodDefinition.Occasion.BIRTHDAY.toString()
                        )
                ),
                Flower.giftCheck(BigInteger.TEN),
                Flower.giftCheck(BigInteger.valueOf(100)),
                Flower.giftCheck(BigInteger.valueOf(50))
        );
        repository.saveAll(flowers);

    }

    private byte[] readImage(String imageName) throws IOException {
        return this.getClass().getClassLoader().getResourceAsStream("static/images/" + imageName).readAllBytes();
    }
}
