package org.ecommerce.functionnalityecommerce.service;

import lombok.RequiredArgsConstructor;
import org.ecommerce.functionnalityecommerce.entity.Product;
import org.ecommerce.functionnalityecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;

    public Product create(Product p) { return productRepo.save(p); }
    public Product update(Long id, Product p) {
        Product prod = productRepo.findById(id).orElseThrow();
        prod.setName(p.getName());
        prod.setPrice(p.getPrice());
        prod.setStock(p.getStock());
        return productRepo.save(prod);
    }
    public void delete(Long id) { productRepo.deleteById(id); }
}
