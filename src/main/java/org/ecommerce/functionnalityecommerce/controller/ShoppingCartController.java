package org.ecommerce.functionnalityecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.ecommerce.functionnalityecommerce.entity.ShoppingCart;
import org.ecommerce.functionnalityecommerce.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService cartService;

    @PostMapping
    public ShoppingCart createCart() { return cartService.createCart(); }

    @PostMapping("/{id}/add-product")
    public ShoppingCart addProduct(@PathVariable Long id, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addProduct(id, productId, quantity);
    }

    @PutMapping("/{id}/update-product")
    public ShoppingCart updateProduct(@PathVariable Long id, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.updateProduct(id, productId, quantity);
    }

    @DeleteMapping("/{id}/remove-product")
    public ShoppingCart removeProduct(@PathVariable Long id, @RequestParam Long productId) {
        return cartService.removeProduct(id, productId);
    }
    @GetMapping("/{id}/total")
    public double getTotal(@PathVariable Long id) {
        return cartService.getTotal(id);
    }
}
