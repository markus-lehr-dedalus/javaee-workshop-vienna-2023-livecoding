package com.dedalus.model.room;

import com.dedalus.entity.Room;
import lombok.Data;
import lombok.experimental.Accessors;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Accessors(chain = true)
public class FullRoomRepresentationModel {
    private long id;
    @Schema(description = "Booking name of the room.")
    private String name;
    private String city;
    private String roomType;
    private int numberOfSeats;
    private int availableFruits;

    public static FullRoomRepresentationModel fromEntity(Room room) {
        return new FullRoomRepresentationModel()
                .setId(room.getId())
                .setName(room.getName())
                .setCity(room.getCity())
                .setRoomType(room.getRoomType().toString())
                .setNumberOfSeats(room.getNumberOfSeats())
                .setAvailableFruits(room.getFruitBowl().getAvailableFruits());
    }
}
