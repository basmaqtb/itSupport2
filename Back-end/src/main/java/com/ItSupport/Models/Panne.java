package com.ItSupport.Models;

import com.ITSupport.Models.Enums.EtatPanne;
import com.ItSupport.Models.Ticket;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Panne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateDetection;

    @Enumerated(EnumType.STRING)
    private EtatPanne etatPannet;


    @OneToMany(mappedBy = "panne", cascade = CascadeType.ALL)
    private List<Ticket> tickets;


}

