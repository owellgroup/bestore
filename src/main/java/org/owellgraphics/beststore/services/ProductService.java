package org.owellgraphics.beststore.services;
import org.owellgraphics.beststore.models.Products;
import org.owellgraphics.beststore.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    //first Auto wire it from the JPA
    @Autowired
    private ProductsRepository repo;

    //we write the CRUD functions

   //save products methods
    public Products saveProduct(Products product) {
        return repo.save(product);
    }
    //save all methods
    public List<Products> saveProducts (List<Products> saveProducts) {
        return repo.saveAll(saveProducts);
    }

    public List<Products> getProducts() {
        return repo.findAll();
    }

    //getting the products by id
    public Products getById(int id) {
        return repo.findById(id).orElse(null);
    }
    //find product by name
    public Products getByName(String name) {
        return repo.findByName(name);
    }

    public Products deleteProduct(int id) {
        return repo.deleteById(id);
    }
    //public String deleteProductById(int id) {
    //    repo.deleteById(id);
     //   return "Product deleted";
   // }

    //delete method for all products


    public Products updateProduct(Products product) {
        Products oldProduct = repo.findById(product.getId()).orElse(null);
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        return repo.save(oldProduct);

    }

}
