package ru.markelov.SpringData.SpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.markelov.SpringData.SpringData.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product getProductById(Long id);

   List<Product> findAllByCostIsBetweenOrderByCost(int min, int max);

   List<Product> findAllByCostIsLessThan(int max);

   List<Product> findAllByCostGreaterThan(int min);

}
