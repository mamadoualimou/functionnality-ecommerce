package org.ecommerce.functionnalityecommerce.repository;

import org.ecommerce.functionnalityecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
