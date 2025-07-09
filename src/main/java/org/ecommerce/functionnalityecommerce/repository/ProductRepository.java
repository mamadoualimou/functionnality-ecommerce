package org.ecommerce.functionnalityecommerce.repository;

import org.ecommerce.functionnalityecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
