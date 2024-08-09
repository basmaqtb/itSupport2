package com.ItSupport.Services;

import com.ItSupport.DTO.EquipementDTO;
import com.ItSupport.Dao.PanneRepository;
import com.ItSupport.DTO.PanneDTO;
import com.ItSupport.Mappers.PanneMapper;
import com.ItSupport.Models.Equipement;
import com.ItSupport.Models.Panne;
import com.ItSupport.exception.EquipmentNotFoundException;
import com.ItSupport.exception.PanneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanneService {

    @Autowired
    private PanneRepository panneRepository;

    @Autowired
    private PanneMapper panneMapper;

    public Panne createPanne(PanneDTO panneDto) {
        var panne = panneMapper.toEntity(panneDto);
        return panneRepository.save(panne);
    }

    public List<Panne> getAllPannes() {
        var pannes = panneRepository.findAll();
        if (pannes.isEmpty()){
            throw new EquipmentNotFoundException();
        }
        return pannes;
    }

    public PanneDTO getPanneById(Long id) {
        var panne = panneRepository.findById(id)
                .orElseThrow(() -> new PanneNotFoundException());
        return panneMapper.toDto(panne);
    }

    public Panne updatePanne(Long id, PanneDTO panneDTO) {
        var panne = panneRepository.findById(id).orElseThrow(EquipmentNotFoundException::new);
        var updatedPanne = panneMapper.partialUpdate(panneDTO,panne);
        return panneRepository.save(updatedPanne);
    }

    public void deletePanne(Long id) {
        var panne = panneRepository.findById(id)
                .orElseThrow(() -> new PanneNotFoundException());
        panneRepository.delete(panne);
    }
}
