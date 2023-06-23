package com.dedalus.resource;

import com.dedalus.entity.Room;
import com.dedalus.model.AirQuality;
import com.dedalus.model.room.FullRoomRepresentationModel;
import com.dedalus.model.room.RoomCreationModel;
import com.dedalus.model.room.RoomRepresentationModel;
import com.dedalus.service.ApiNinjaService;
import com.dedalus.service.ImportantService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.inject.Inject;
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
@Slf4j
public class RoomResource {
    @Inject
    ApiNinjaService apiNinjaService;

    @Inject
    ImportantService importantService;

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
        AirQuality airQuality = apiNinjaService.getAirQuality(room.getCity());
        return FullRoomRepresentationModel
                .fromEntity(room)
                .setAirQuality(airQuality);
    }

    @POST
    @Retry(maxRetries = 5)
    public FullRoomRepresentationModel createRoom(@Valid RoomCreationModel room) {
        importantService.slowMethodThatCouldFail();
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