package lt.mif.flowershop;

import lt.mif.flowershop.dao.FlowerRepository;
import lt.mif.flowershop.entity.Flower;
import lt.mif.flowershop.entity.MoodDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
import java.util.List;

@SpringBootApplication
public class FlowerShopApplication implements CommandLineRunner {

    private final FlowerRepository repository;

    @Autowired
    public FlowerShopApplication(FlowerRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlowerShopApplication.class, args);
    }

    @Override
    public void run(String... args) {
        var flowers = List.of(Flower.singleFlower("Rose", "Red", BigInteger.TWO, 10, new byte[0],
                List.of(
                        MoodDefinition.Style.MINIMALIST.toString(),
                        MoodDefinition.Style.ROMANTIC.toString(),
                        MoodDefinition.AgeGroup.ADULT.toString(),
                        MoodDefinition.AgeGroup.SENIOR.toString(),
                        MoodDefinition.ColorPalette.DEEP.toString(),
                        MoodDefinition.Occasion.CELEBRATION.toString(),
                        MoodDefinition.Occasion.BIRTHDAY.toString()
                )
                ),
                Flower.singleFlower("Tulip", "Purple", BigInteger.valueOf(3), 14, new byte[0],
                        List.of(
                                MoodDefinition.Style.MINIMALIST.toString(),
                                MoodDefinition.AgeGroup.ADULT.toString(),
                                MoodDefinition.AgeGroup.SENIOR.toString(),
                                MoodDefinition.AgeGroup.KID.toString(),
                                MoodDefinition.ColorPalette.DEEP.toString(),
                                MoodDefinition.Occasion.CELEBRATION.toString(),
                                MoodDefinition.Occasion.BIRTHDAY.toString()
                        )
                ),
                Flower.bouquet("Bouquet of white roses", List.of("white"), 9, BigInteger.valueOf(10), 5, new byte[0],
                        List.of(
                                MoodDefinition.Style.ROMANTIC.toString(),
                                MoodDefinition.AgeGroup.ADULT.toString(),
                                MoodDefinition.ColorPalette.LIGHT.toString(),
                                MoodDefinition.Occasion.WEDDING.toString()
                        )
                ),
                Flower.bouquet("Funeral bouquet", List.of("white"), 20, BigInteger.valueOf(30), 5, new byte[0],
                        List.of(
                                MoodDefinition.Style.MINIMALIST.toString(),
                                MoodDefinition.ColorPalette.LIGHT.toString(),
                                MoodDefinition.AgeGroup.KID.toString(),
                                MoodDefinition.AgeGroup.SENIOR.toString(),
                                MoodDefinition.AgeGroup.ADULT.toString(),
                                MoodDefinition.Occasion.FUNERAL.toString()
                        )
                ),
                Flower.potFlower("Cactus", List.of("Green"), 1, BigInteger.valueOf(7), 4, new byte[0],
                        List.of(
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
}
