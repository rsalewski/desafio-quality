package com.bootcampmeli.calcproperty.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyResponseDTO {


    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double totalPrice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String biggerRoom;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double totalArea;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RoomResponseDTO> rooms = new ArrayList<>();

   public void addRoom(RoomResponseDTO roomResponseDTO){
       rooms.add(roomResponseDTO);
   }

}
