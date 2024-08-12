package com.ItSupport.Controllers;

import com.ItSupport.DTO.EquipementDTO;
import com.ItSupport.Mappers.EquipementMapper;
import com.ItSupport.Models.Equipement;
import com.ItSupport.Services.EquipementService;
import com.ItSupport.exception.EquipmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/equipements")
public class EquipementController {

    @Autowired
    private EquipementService equipementService;

    @Autowired
    private EquipementMapper equipementMapper;

    @GetMapping("/show")
    public ResponseEntity<List<EquipementDTO>> getAllEquipements() {
        List<Equipement> equipements = equipementService.getAllEquipments();
        return ResponseEntity.ok(equipementMapper.toDto(equipements));
    }

    @PostMapping("/add")
    public ResponseEntity<EquipementDTO> createEquipement(@RequestBody EquipementDTO equipementDTO) {
        var createdEquipement = equipementService.createEquipment(equipementDTO);
        return ResponseEntity.status(201).body(equipementMapper.toDto(createdEquipement));
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        var  equipement = equipementService.getEquipmentById(id);
        return ResponseEntity.ok(equipement);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEquipement(@PathVariable Long id, @RequestBody EquipementDTO updatedEquipement) {
        try {
            var equipement = equipementService.getEquipmentById(id);
            var updatedTechnician = equipementMapper.partialUpdate(updatedEquipement, equipement);
            return ResponseEntity.ok(updatedTechnician);
        } catch (EquipmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        equipementService.deleteEquipment(id);
        return ResponseEntity.noContent().build();
    }
}
