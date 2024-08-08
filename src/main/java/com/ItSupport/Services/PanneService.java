package com.ItSupport.Services;

import com.ItSupport.Dao.PanneRepository;
import com.ItSupport.Models.Panne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanneService {

    @Autowired
    private PanneRepository panneRepository;

    public List<Panne> getAllPannes() {
        return panneRepository.findAll();
    }

    public Panne addPanne(Panne panne) {
        return panneRepository.save(panne);
    }

    public Optional<Panne> getPanneById(Long id) {
        return panneRepository.findById(id);
    }

    public Panne updatePanne(Long id, Panne updatedPanne) {
        return panneRepository.findById(id)
                .map(panne -> {
                    panne.setDescription(updatedPanne.getDescription());
                    panne.setDateDetection(updatedPanne.getDateDetection());
                    panne.setEtatPannet(updatedPanne.getEtatPannet());
                    // Mettez à jour les autres champs nécessaires
                    return panneRepository.save(panne);
                })
                .orElseThrow(() -> new RuntimeException("Panne non trouvée avec ID : " + id));
    }

    public void deletePanne(Long id) {
        panneRepository.deleteById(id);
    }
}
