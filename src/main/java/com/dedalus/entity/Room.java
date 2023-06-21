package com.dedalus.entity;

import com.dedalus.model.room.RoomCreationModel;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
public class Room extends PanacheEntityBase {
    @Id
    @GeneratedValue
    private Long id;
    private RoomType roomType;
    private Integer numberOfSeats;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fruit_bowl")
    private FruitBowl fruitBowl;

    public static Room fromCreationModel(RoomCreationModel roomCreationModel) {
        return new Room()
                .setRoomType(RoomType.fromString(roomCreationModel.getRoomType()))
                .setName(roomCreationModel.getName())
                .setNumberOfSeats(roomCreationModel.getNumberOfSeats())
                .setFruitBowl(new FruitBowl().setAvailableFruits(4));
    }
}
