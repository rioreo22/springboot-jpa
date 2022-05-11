package com.example.jpalecture.domain.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "item")
@Entity
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int price;
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "order_item_id", referencedColumnName = "id")
    private OrderItem orderItem;

    public void setOrderItem(OrderItem orderItem) {
        if (Objects.nonNull(this.orderItem)) {
            this.orderItem.getItems().remove(this);
        }

        this.orderItem = orderItem;
        orderItem.getItems().add(this);
    }
}
