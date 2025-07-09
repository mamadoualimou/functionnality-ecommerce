package org.ecommerce.functionnalityecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.ecommerce.functionnalityecommerce.entity.Product;
import org.ecommerce.functionnalityecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product p) { return productService.create(p); }
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p) { return productService.update(id, p); }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { productService.delete(id); }
}
