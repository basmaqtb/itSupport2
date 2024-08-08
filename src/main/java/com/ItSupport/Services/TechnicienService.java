package com.ItSupport.Services;

import com.ItSupport.Dao.TechnicienRepository;
import com.ItSupport.Models.heritage.Technicien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicienService {

    @Autowired
    private TechnicienRepository technicienRepository;

    public List<Technicien> getAllTechniciens() {
        return technicienRepository.findAll();
    }

    public Technicien addTechnicien(Technicien technicien) {
        return technicienRepository.save(technicien);
    }

    public Optional<Technicien> getTechnicienById(Long id) {
        return technicienRepository.findById(id);
    }

    public Technicien updateTechnicien(Long id, Technicien updatedTechnicien) {
        return technicienRepository.findById(id)
                .map(technicien -> {
                    technicien.setNom(updatedTechnicien.getNom());
                    technicien.setEmail(updatedTechnicien.getEmail());
                    // Mettez à jour les autres champs
                    return technicienRepository.save(technicien);
                })
                .orElseThrow(() -> new RuntimeException("Technicien non trouvé avec ID : " + id));
    }

    public void deleteTechnicien(Long id) {
        technicienRepository.deleteById(id);
    }
}
