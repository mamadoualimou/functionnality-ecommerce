package org.ecommerce.functionnalityecommerce.service;

import lombok.RequiredArgsConstructor;
import org.ecommerce.functionnalityecommerce.entity.Category;
import org.ecommerce.functionnalityecommerce.entity.Product;
import org.ecommerce.functionnalityecommerce.repository.CategoryRepository;
import org.ecommerce.functionnalityecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;
    public Category create(Category category) { return categoryRepo.save(category); }
    public Category update(Long id, Category c) {
        Category cat = categoryRepo.findById(id).orElseThrow();
        cat.setName(c.getName());
        cat.setDescription(c.getDescription());
        return categoryRepo.save(cat);
    }
    public void delete(Long id) { categoryRepo.deleteById(id); }
    public Category linkProduct(Long catId, Long prodId) {
        Category cat = categoryRepo.findById(catId).orElseThrow();
        Product p = productRepo.findById(prodId).orElseThrow();
        cat.getProducts().add(p);
        return categoryRepo.save(cat);
    }
    public Category unlinkProduct(Long catId, Long prodId) {
        Category cat = categoryRepo.findById(catId).orElseThrow();
        cat.getProducts().removeIf(p -> p.getId().equals(prodId));
        return categoryRepo.save(cat);
    }
}
