package com.bootcampmeli.calcproperty.builder;

import com.bootcampmeli.calcproperty.model.entity.Property;
import com.bootcampmeli.calcproperty.model.entity.Room;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PropertyBuilder {

    private Property property;

    public static PropertyBuilder validProperty(){
        PropertyBuilder propertyBuilder = new PropertyBuilder();

        Room room1 = new Room().builder().name("Room3").length(4.0).width(3.0).build();
        Room room2 = new Room().builder().name("Room1").length(5.0).width(3.0).build();
        Room room3 = new Room().builder().name("Room2").length(6.0).width(5.0).build();

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        propertyBuilder.property = new Property().builder()
                .name("Rayan house")
                .district("New york")
                .valueDistrict(8000.0)
                .rooms(rooms)
                .build();

        return propertyBuilder;
    }

    public Property build(){
        return this.property;
    }
}
