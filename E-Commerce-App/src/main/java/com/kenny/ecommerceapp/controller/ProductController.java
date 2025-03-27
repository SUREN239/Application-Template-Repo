package com.kenny.ecommerceapp.controller;

import com.kenny.ecommerceapp.model.Product;
import com.kenny.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/demo")
    public String demoCon()
    {
        return "This is from Demo";
    }

    @PostMapping("/add")
    public String createProduct(@RequestBody Product product)
    {
        Product product1 = productService.createProduct(product);
        if(product1 != null)
        {
            return "Product Added";
        }
        return "Error Exists";
    }

//    @GetMapping
//    public List<Product> getAllProduct()
//    {
//        return productService.getAllProducts();
//    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Long id)
    {
        return productService.getById(id);
    }
    @GetMapping
    public Optional<Product> getByIdRe(@RequestParam Long id)
    {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updated)
    {
        return productService.update(id,updated);
    }

}
