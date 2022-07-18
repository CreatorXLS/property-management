package com.property.management.propertmanagement.controller;

import com.property.management.propertmanagement.dto.PropertyDTO;
import com.property.management.propertmanagement.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);

        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);

    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
        propertyDTO = propertyService.updateProperty(propertyDTO,id);
        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    }
    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO,id);
        return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    }

    @DeleteMapping("/properties/{id}")
    public void deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
    }
}
