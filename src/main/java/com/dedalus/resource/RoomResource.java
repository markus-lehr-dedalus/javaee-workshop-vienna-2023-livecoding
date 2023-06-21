package com.dedalus.resource;

import com.dedalus.entity.Room;
import com.dedalus.model.room.FullRoomRepresentationModel;
import com.dedalus.model.room.RoomCreationModel;
import com.dedalus.model.room.RoomRepresentationModel;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/resources/room")
@Transactional()
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {
    @GET
    public List<RoomRepresentationModel> getRooms() {
        Stream<Room> rooms = Room.streamAll();
        return rooms
                .map(RoomRepresentationModel::fromEntity)
                .collect(Collectors.toList());
    }

    @GET
    @Path("{roomId}")
    public FullRoomRepresentationModel getRoom(@PathParam("roomId") Long roomId) {
        Room room = Room.findById(roomId);
        return FullRoomRepresentationModel.fromEntity(room);
    }

    @POST
    public FullRoomRepresentationModel createRoom(@Valid RoomCreationModel room) {
        Room roomEntity = Room.fromCreationModel(room);
        roomEntity.persistAndFlush();
        return FullRoomRepresentationModel.fromEntity(roomEntity);
    }

    @PUT
    @Path("fruit/{roomId}")
    public FullRoomRepresentationModel getFruit(@PathParam("roomId") Long roomId) {
        Room room = Room.findById(roomId);
        room.getFruitBowl().decrementAvailableFruits();
        return FullRoomRepresentationModel.fromEntity(room);
    }
}