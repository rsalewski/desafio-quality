package com.bootcampmeli.calcproperty.service;

import com.bootcampmeli.calcproperty.api.dto.PropertyResponseDTO;
import com.bootcampmeli.calcproperty.api.dto.RoomResponseDTO;
import com.bootcampmeli.calcproperty.model.entity.Property;
import com.bootcampmeli.calcproperty.model.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private PropertyResponseDTO propertyResponseDTO;

    public PropertyResponseDTO getTotalAreaProperty(Property property) {
        propertyResponseDTO = new PropertyResponseDTO();

        return propertyResponseDTO.builder()
                .name(property.getName())
                .totalArea(property.totalAreaProperty())
                .build();
    }

    public PropertyResponseDTO getTotalPriceProperty(Property property) {
        propertyResponseDTO = new PropertyResponseDTO();

        return propertyResponseDTO.builder()
                .name(property.getName())
                .totalPrice(property.totalPriceProperty())
                .build();
    }

    public PropertyResponseDTO getBiggerRoom(Property property) {
        propertyResponseDTO = new PropertyResponseDTO();

        return propertyResponseDTO.builder()
                .name(property.getName())
                .biggerRoom(property.biggerRoom().getName())
                .build();
    }

    public PropertyResponseDTO getAreaRooms(Property property) {
        propertyResponseDTO = new PropertyResponseDTO();

        propertyResponseDTO.setName(property.getName());

        for (Room room:property.getRooms()) {
            propertyResponseDTO.addRoom(
                    new RoomResponseDTO(
                            room.getName(), room.getSquareMeters()
                    )
            );
        }
        return propertyResponseDTO;
    }
}
