package com.ItSupport.Controllers;

import com.ItSupport.Models.heritage.Technicien;
import com.ItSupport.Services.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/techniciens")
public class TechnicienController {

    @Autowired
    private TechnicienService technicienService;

    @GetMapping("/show")
    public ResponseEntity<List<Technicien>> getAllTechniciens() {
        List<Technicien> techniciens = technicienService.getAllTechniciens();
        return ResponseEntity.ok(techniciens);
    }

    @PostMapping("/add")
    public Technicien addTechnicien(@RequestBody Technicien technicien) {
        return technicienService.addTechnicien(technicien);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Technicien> getTechnicienById(@PathVariable Long id) {
        Optional<Technicien> technicien = technicienService.getTechnicienById(id);
        return technicien.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Technicien> updateTechnicien(@PathVariable Long id, @RequestBody Technicien updatedTechnicien) {
        try {
            Technicien technicien = technicienService.updateTechnicien(id, updatedTechnicien);
            return ResponseEntity.ok(technicien);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTechnicien(@PathVariable Long id) {
        technicienService.deleteTechnicien(id);
        return ResponseEntity.noContent().build();
    }
}
