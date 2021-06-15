package com.bootcampmeli.calcproperty.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {

    @Size(max = 30, message = "Room name size must not exceed 30 characters")
    @Pattern(regexp = "^([A-Z]+)([a-z]|[A-Z]|[0-9]|\\s)+", message = "Room name must start with a uppercase letter")
    @NotEmpty(message = "Name cannot be empty or null")
    @JsonProperty(value = "roomName")
    private String name;

    @JsonProperty(value = "roomWidth")
    @NotNull(message = "Room length cannot be empty")
    @Positive
    @Max(value = 25, message = "Room width cannot be longer than 25m")
    private Double width;

    @JsonProperty(value = "roomLength")
    @NotNull(message = "Room length cannot be empty")
    @Positive
    @Max(value = 33, message = "Room width cannot be longer than 33m")
    private Double length;

    public Double getSquareMeters() {
        return width * length;
    }

}
