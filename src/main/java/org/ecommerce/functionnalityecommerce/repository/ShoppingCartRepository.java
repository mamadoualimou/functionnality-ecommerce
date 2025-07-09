package org.ecommerce.functionnalityecommerce.repository;

import org.ecommerce.functionnalityecommerce.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
