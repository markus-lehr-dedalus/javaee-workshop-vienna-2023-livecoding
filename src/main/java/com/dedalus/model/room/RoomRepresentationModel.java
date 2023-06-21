package com.dedalus.model.room;

import com.dedalus.entity.Room;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoomRepresentationModel {
    private long id;
    private String name;
    private String roomType;
    private int numberOfSeats;

    public static RoomRepresentationModel fromEntity(Room room) {
        return new RoomRepresentationModel()
                .setId(room.getId())
                .setName(room.getName())
                .setRoomType(room.getRoomType().toString())
                .setNumberOfSeats(room.getNumberOfSeats());
    }
}
