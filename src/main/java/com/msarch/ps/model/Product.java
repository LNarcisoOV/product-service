package com.msarch.ps.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    @Column(name = "PRODUCT", length = 100, nullable = false)
    private String description;

    @Column(name = "VALUE", nullable = false)
    private BigDecimal value;

    @Deprecated
    public Product() {
    }

    public Product(@NonNull String name, @NonNull String description, @NonNull BigDecimal value) {
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && name.equals(product.name) && description.equals(product.description) && value.equals(product.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, value);
    }
}
