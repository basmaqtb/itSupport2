package com.ItSupport.Services;

import com.ItSupport.DTO.EquipementDTO;
import com.ItSupport.Dao.EquipementRepository;
import com.ItSupport.Mappers.EquipementMapper;
import com.ItSupport.Models.Enums.EtatEquipement;
import com.ItSupport.Models.Equipement;
import com.ItSupport.exception.EquipmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;
    @Autowired
    private EquipementMapper equipmentMapper;

    public Equipement createEquipment(EquipementDTO equipmentDto) {
        var equipment = equipmentMapper.toEntity(equipmentDto);
        equipment.setEtat(EtatEquipement.Disponible);
        return equipementRepository.save(equipment);
    }

    public List<Equipement> getAllEquipments() {
        var equipments = equipementRepository.findAll();
        if (equipments.isEmpty()){
            throw new EquipmentNotFoundException();
        }
        return equipments;
    }

    public Equipement getEquipmentById(Long id) {
        return equipementRepository.findById(id).orElseThrow(EquipmentNotFoundException::new);
    }

    public Equipement updateEquipment(Long id, EquipementDTO equipmentDto) {
        var equipment = equipementRepository.findById(id).orElseThrow(EquipmentNotFoundException::new);
        var updatedEquipment = equipmentMapper.partialUpdate(equipmentDto, equipment);
        return equipementRepository.save(updatedEquipment);
    }

    public void deleteEquipment(Long id) {
        var equipment = equipementRepository.findById(id).orElseThrow(EquipmentNotFoundException::new);
        equipementRepository.delete(equipment);
    }

    public Equipement assignEquipmentToClient(Long equipmentId, Long clientId){
        var equipment = equipementRepository.findById(equipmentId).orElseThrow(EquipmentNotFoundException::new);
        equipment.setEtat(EtatEquipement.Disponible);
        return equipementRepository.save(equipment);
    }

//    public List<Equipement> getAllEquipmentOutService(){
//        var equipments = equipementRepository.findAllByEtatEquipement(EtatEquipement.NonDisponible);
//        if (equipments.isEmpty()){
//            throw new EquipmentNotFoundException();
//        }
//        return equipments;
//    }

}
