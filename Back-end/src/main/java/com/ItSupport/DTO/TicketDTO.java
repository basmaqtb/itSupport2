package com.ItSupport.DTO;

import com.ITSupport.Models.Enums.StatutTicket;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDTO implements Serializable {
    private Long id;
    private String description;
    private Date dateCreation;
    private StatutTicket statut;
    private Long technicienId;
    private Long utilisateurId;
    private Long panneId;
    private Long equipementId;
}
