package org.owellgraphics.beststore.controllers;
import org.owellgraphics.beststore.services.ProductService;
import org.owellgraphics.beststore.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {
    //we inject services here with @autowired
    @Autowired
    private ProductService service;

    //post method one at a time
    @PostMapping("/api/addProduct")
    public Products addProduct(@RequestBody Products product) {
        return service.saveProduct(product);
    }

    //post method in group
    @PostMapping("/api/addProducts")
    public List<Products> addProducts(@RequestBody List<Products> products) {
        return service.saveProducts(products);
    }

    //Get methods
    @GetMapping("/api/products")
    public List<Products> findAllProducts() {
        return service.getProducts();
    }

    //get product by ID
    @GetMapping("/api/products/{id}")
    public Products findProductById(@PathVariable int id) {
        return service.getById(id);
    }

    //find product by price
    @GetMapping("/api/products/{name}")
    public Products getByName(String name) {
        return service.getByName(name);
    }

    //deleting
    @DeleteMapping("/api/delete{id}")
    public Products deleteProduct(@PathVariable int id) {
          return service.deleteProduct(id);

    }

    //update products
    @PutMapping("/api/update")
    public Products updateProducts(@RequestBody Products products) {
        return service.updateProduct(products);
    }


    //delete methods

}
