package com.ItSupport.Models;

import com.ITSupport.Models.Enums.StatutTicket;
import com.ItSupport.Models.heritage.Technicien;

import com.ItSupport.Models.heritage.Utilisateur;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private StatutTicket statut;

    @ManyToOne
    private Technicien technicien;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Panne panne;

    @ManyToOne
    private Equipement equipement;
}
