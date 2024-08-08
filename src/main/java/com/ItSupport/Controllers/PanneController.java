package com.ItSupport.Controllers;

import com.ItSupport.Models.Panne;
import com.ItSupport.Services.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pannes")
public class PanneController {

    @Autowired
    private PanneService panneService;

    @GetMapping("/show")
    public ResponseEntity<List<Panne>> getAllPannes() {
        List<Panne> pannes = panneService.getAllPannes();
        return ResponseEntity.ok(pannes);
    }

    @PostMapping("/add")
    public Panne addPanne(@RequestBody Panne panne) {
        return panneService.addPanne(panne);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Panne> getPanneById(@PathVariable Long id) {
        Optional<Panne> panne = panneService.getPanneById(id);
        return panne.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Panne> updatePanne(@PathVariable Long id, @RequestBody Panne updatedPanne) {
        try {
            Panne panne = panneService.updatePanne(id, updatedPanne);
            return ResponseEntity.ok(panne);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePanne(@PathVariable Long id) {
        panneService.deletePanne(id);
        return ResponseEntity.noContent().build();
    }
}
