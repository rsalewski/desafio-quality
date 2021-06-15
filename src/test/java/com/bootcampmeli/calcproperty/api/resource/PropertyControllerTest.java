package com.bootcampmeli.calcproperty.api.resource;

import ch.qos.logback.core.joran.spi.DefaultClass;
import com.bootcampmeli.calcproperty.api.dto.PropertyResponseDTO;
import com.bootcampmeli.calcproperty.builder.PropertyBuilder;
import com.bootcampmeli.calcproperty.model.entity.Property;
import com.bootcampmeli.calcproperty.service.PropertyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(PropertyController.class)
@ExtendWith(SpringExtension.class)
public class PropertyControllerTest {

    static String PROPERTY_API = "/properties";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PropertyService service;

    @Test
    @DisplayName("Should throw error for insufficient data.")
    public void insufficientData() throws Exception {

        String json = new ObjectMapper().writeValueAsString(new Property());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(PROPERTY_API.concat("/totalArea"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should get total area.")
    public void ShouldGetTotalArea() throws Exception {

        Property propertyValid = PropertyBuilder.validProperty().build();

        String json = new ObjectMapper().writeValueAsString(propertyValid);

        when(service.getTotalAreaProperty(propertyValid)).thenReturn(
                new PropertyResponseDTO().builder()
                        .name("Rayan House")
                        .totalArea(57.0)
                        .build());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(PROPERTY_API.concat("/totalArea"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalArea").value(57.0));
    }
    

}
