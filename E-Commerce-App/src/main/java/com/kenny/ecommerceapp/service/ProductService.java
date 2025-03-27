package com.kenny.ecommerceapp.service;

import com.kenny.ecommerceapp.model.Product;
import com.kenny.ecommerceapp.repo.ProductRepo;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.spi.ResolveResult;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Product createProduct(Product product) {
        return productRepo.save(product);

    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }


    public Optional<Product> getById(Long id) {
        return productRepo.findById(id);
    }

    public Product update(Long id, Product updated) {
        Product existing =  productRepo.findById(id).orElse(null);
        if(existing !=null)
        {
            existing.setName(updated.getName());
            existing.setPrice(updated.getPrice());
            return productRepo.save((existing));
        }
        return null;
    }

    public List<Product> helper()
    {
        Product[] products = restTemplate.getForObject("https://api.example.com/products",Product[].class);
        return Arrays.asList(products);
    }
}
