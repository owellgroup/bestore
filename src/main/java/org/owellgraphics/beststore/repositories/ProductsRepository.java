package org.owellgraphics.beststore.repositories;

import org.owellgraphics.beststore.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
  Products findByName(String name);


  Products deleteById(int id);
}