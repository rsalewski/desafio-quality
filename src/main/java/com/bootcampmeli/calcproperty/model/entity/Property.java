package com.bootcampmeli.calcproperty.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Comparator;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Size(max = 30, message = "Room name size must not exceed 30 characters")
    @Pattern(regexp = "^([A-Z]+)([a-z]|[A-Z]|[0-9]|\\s)+", message = "Room name must start with a uppercase letter")
    @NotEmpty(message = "Name cannot be empty or null")
    private String name;

    @Size(max = 45, message = "District cannot exceed 45 characters")
    @NotEmpty(message = "District cannot be empty or null")
    private String district;

    @NotNull(message = "Room length cannot be empty")
    @Positive
    private Double valueDistrict;

    @Valid
    @NotEmpty(message = "There must be at least one room")
    private List<Room> rooms;

    public Double totalAreaProperty() {
        return rooms.stream().map(Room::getSquareMeters).reduce(Double::sum).get();
    }

    public Double totalPriceProperty() {
        return totalAreaProperty() * valueDistrict;
    }

    public Room biggerRoom() {
        return rooms.stream().max(Comparator.comparingDouble(Room::getSquareMeters)).get();
    }

}
