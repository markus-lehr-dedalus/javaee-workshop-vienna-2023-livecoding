package com.dedalus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
public class FruitBowl extends PanacheEntityBase {
    @Id
    @GeneratedValue
    private Long id;
    private Integer availableFruits;
    @OneToOne(mappedBy = "fruitBowl")
    private Room room;

    public void decrementAvailableFruits() {
        if (availableFruits == 0) {
            throw new IllegalStateException("No fruit to take available");
        }
        this.availableFruits--;
    }
}
