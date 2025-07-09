package org.ecommerce.functionnalityecommerce.service;

import lombok.RequiredArgsConstructor;
import org.ecommerce.functionnalityecommerce.entity.CartItem;
import org.ecommerce.functionnalityecommerce.entity.Product;
import org.ecommerce.functionnalityecommerce.entity.ShoppingCart;
import org.ecommerce.functionnalityecommerce.repository.CartItemRepository;
import org.ecommerce.functionnalityecommerce.repository.ProductRepository;
import org.ecommerce.functionnalityecommerce.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository cartRepo;
    private final ProductRepository productRepo;
    private final CartItemRepository cartItemRepo;
    public ShoppingCart createCart() {
        return cartRepo.save(new ShoppingCart());
    }

    public ShoppingCart addProduct(Long cartId, Long productId, int quantity) {
        ShoppingCart cart = cartRepo.findById(cartId).orElseThrow();
        Product product = productRepo.findById(productId).orElseThrow();
        CartItem item = new CartItem(null, cart, product, quantity);
        cart.getItems().add(item);
        return cartRepo.save(cart);
    }

    public ShoppingCart updateProduct(Long cartId, Long productId, int quantity) {
        ShoppingCart cart = cartRepo.findById(cartId).orElseThrow();
        cart.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(i -> i.setQuantity(quantity));
        return cartRepo.save(cart);
    }

    public ShoppingCart removeProduct(Long cartId, Long productId) {
        ShoppingCart cart = cartRepo.findById(cartId).orElseThrow();
        cart.getItems().removeIf(i -> i.getProduct().getId().equals(productId));
        return cartRepo.save(cart);
    }

    public double getTotal(Long cartId) {
        return cartRepo.findById(cartId).map(ShoppingCart::getTotal).orElse(0.0);
    }
}
