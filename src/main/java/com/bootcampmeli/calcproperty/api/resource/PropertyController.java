package com.bootcampmeli.calcproperty.api.resource;

import com.bootcampmeli.calcproperty.api.dto.PropertyResponseDTO;
import com.bootcampmeli.calcproperty.model.entity.Property;
import com.bootcampmeli.calcproperty.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/totalArea")
    public PropertyResponseDTO getTotalAreaProperty(@Valid @RequestBody Property property){
        return propertyService.getTotalAreaProperty(property);
    }

    @PostMapping("/totalPrice")
    public PropertyResponseDTO getTotalPriceProperty(@Valid @RequestBody Property property){
        return propertyService.getTotalPriceProperty(property);
    }

    @PostMapping("/biggerRoom")
    public PropertyResponseDTO getBiggerRoom(@Valid @RequestBody Property property){
        return propertyService.getBiggerRoom(property);
    }

    @PostMapping("/areaRooms")
    public PropertyResponseDTO getAreaRooms(@Valid @RequestBody Property property){
        return propertyService.getAreaRooms(property);
    }
}
