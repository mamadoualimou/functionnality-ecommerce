package org.ecommerce.functionnalityecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mamadou-Alimou Diallo
 * 09/07/2025
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ShoppingCart cart;

    @ManyToOne
    private Product product;

    private Integer quantity;
}
