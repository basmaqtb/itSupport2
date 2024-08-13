package com.ItSupport.DTO;

import com.ITSupport.Models.Enums.EtatPanne;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PanneDTO implements Serializable {
    private Long id;
    private String description;
    private Date dateDetection;
    private EtatPanne etatPannet;
    private List<Long> ticketIds;

}
