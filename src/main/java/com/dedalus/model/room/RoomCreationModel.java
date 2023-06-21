package com.dedalus.model.room;

import lombok.Data;
import lombok.experimental.Accessors;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class RoomCreationModel {
    @NotBlank
    @Size(min = 3)
    private String name;
    @Schema(enumeration = {"meeting", "relaxation"})
    private String roomType;
    @Min(2)
    @Max(100)
    private int numberOfSeats;
}
