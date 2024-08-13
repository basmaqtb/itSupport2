package com.ItSupport.Dao;

import com.ItSupport.Models.Enums.EtatEquipement;
import com.ItSupport.Models.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipementRepository extends JpaRepository<Equipement , Long> {
   // List<Equipement> findAllByEtatEquipement(EtatEquipement etat);

}
