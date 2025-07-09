package org.ecommerce.functionnalityecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    public double getTotal() {
        return items.stream().mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice()).sum();
    }
}
