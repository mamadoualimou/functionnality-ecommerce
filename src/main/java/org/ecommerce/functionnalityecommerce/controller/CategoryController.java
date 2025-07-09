package org.ecommerce.functionnalityecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.ecommerce.functionnalityecommerce.entity.Category;
import org.ecommerce.functionnalityecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public Category create(@RequestBody Category c) { return categoryService.create(c); }
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category c) { return categoryService.update(id, c); }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { categoryService.delete(id); }

    @PostMapping("/{id}/products/{productId}")
    public Category link(@PathVariable Long id, @PathVariable Long productId) {
        return categoryService.linkProduct(id, productId);
    }

    @DeleteMapping("/{id}/products/{productId}")
    public Category unlink(@PathVariable Long id, @PathVariable Long productId) {
        return categoryService.unlinkProduct(id, productId);
    }
}
