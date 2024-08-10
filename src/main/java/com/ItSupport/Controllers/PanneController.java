package com.ItSupport.Controllers;

import com.ItSupport.DTO.PanneDTO;
import com.ItSupport.Mappers.PanneMapper;
import com.ItSupport.Models.Equipement;
import com.ItSupport.Models.Panne;
import com.ItSupport.Services.PanneService;
import com.ItSupport.exception.PanneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins/pannes")
public class PanneController {

    @Autowired
    private PanneService panneService;

    @Autowired
    private PanneMapper panneMapper;

    @GetMapping("/show")
    public ResponseEntity<List<PanneDTO>> getAllPannes() {
        List<Panne> pannes = panneService.getAllPannes();
        return ResponseEntity.ok(panneMapper.toDto(pannes));
    }

    @PostMapping("/add")
    public ResponseEntity<PanneDTO> createPanne(@RequestBody PanneDTO panneDTO) {
        var createdPanne = panneService.createPanne(panneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(panneMapper.toDto(createdPanne));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanneDTO> getPanneById(@PathVariable Long id) {
        try {
            var panne = panneService.getPanneById(id);
            return ResponseEntity.ok(panne);
        } catch (PanneNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePanne(@PathVariable("id") Long id, @RequestBody PanneDTO updatedPanneDTO) {
        try {
            var panne = panneService.updatePanne(id, updatedPanneDTO);
            return ResponseEntity.ok(panne);
        } catch (PanneNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePanne(@PathVariable Long id) {
        try {
            panneService.deletePanne(id);
            return ResponseEntity.noContent().build();
        } catch (PanneNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
