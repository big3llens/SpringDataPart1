package ru.markelov.SpringData.SpringData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.markelov.SpringData.SpringData.model.Product;
import ru.markelov.SpringData.SpringData.repository.ProductRepository;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class Controller {

    private ProductRepository productRepository;

    @Autowired
    public Controller(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.getProductById(id);
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return (List<Product>)productRepository.findAll();
    }

    @PostMapping("")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/between")
    public List<Product> getListProductBetweenMinMax(@RequestParam int min, @RequestParam int max){
        if(min !=0 & max != 0) return productRepository.findAllByCostIsBetweenOrderByCost(min, max);
        if(min == 0) return productRepository.findAllByCostIsLessThan(max);
        if(max == 0) return productRepository.findAllByCostGreaterThan(min);
        else return (List<Product>)productRepository.findAll();
    }
}
