package com.ItSupport.DTO;

import com.ItSupport.Models.Enums.EtatEquipement;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipementDTO {
    private String type;
    private String marque;
    private String modele;
    private EtatEquipement etat;
}
