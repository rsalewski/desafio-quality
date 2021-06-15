package com.bootcampmeli.calcproperty.service;

import com.bootcampmeli.calcproperty.api.dto.PropertyResponseDTO;
import com.bootcampmeli.calcproperty.builder.PropertyBuilder;
import com.bootcampmeli.calcproperty.model.entity.Property;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class PropertyServiceTest {

    @Autowired
    private PropertyService propertyService;

    private Property property;

    @Test
    @DisplayName("Should return total Area")
    public void shouldGetTotalArea() {
        //cenario
        property = PropertyBuilder.validProperty().build();

        //execucao
        PropertyResponseDTO dto = propertyService.getTotalAreaProperty(property);

        //verificacao
        assertThat(dto.getTotalArea()).isEqualTo(57.0);
    }

    @Test
    @DisplayName("Should return total price by district")
    public void shouldGetTotalPrice() {
        //cenario
        property = PropertyBuilder.validProperty().build();

        //execucao
        PropertyResponseDTO dto = propertyService.getTotalPriceProperty(property);

        //verificacao
        assertThat(dto.getTotalPrice()).isEqualTo(456000.0);

    }

    @Test
    @DisplayName("Should return the bigger room")
    public void shouldGetBiggerRoom() {
        //cenario
        property = PropertyBuilder.validProperty().build();

        //execucao
        PropertyResponseDTO dto = propertyService.getBiggerRoom(property);

        //verificacao
        assertThat(dto.getBiggerRoom()).isEqualTo("TV");
    }

    @Test
    @DisplayName("Should return the calc of all rooms")
    public void shouldCalcAllRooms() {
        //cenario
        property = PropertyBuilder.validProperty().build();

        //execucao
        PropertyResponseDTO dto = propertyService.getAreaRooms(property);

        //verificacao
        assertThat(dto.getRooms().get(0).getArea()).isEqualTo(12.0);
        assertThat(dto.getRooms().get(1).getArea()).isEqualTo(15.0);
        assertThat(dto.getRooms().get(2).getArea()).isEqualTo(30.0);
    }

}
