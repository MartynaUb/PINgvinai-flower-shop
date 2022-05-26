package lt.mif.flowershop.dao;

import lt.mif.flowershop.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Long> {

    List<Flower> findAllByType(Flower.FlowerType flowerType);
}
