package net.ouadoss.repsoitory;

import net.ouadoss.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
// Repository pour gérer les produits avec les opérations CRUD de Spring Data JPA
public interface ProductRepository extends JpaRepository<Product, Long> {
}
