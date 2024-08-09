package com.ItSupport.Models.heritage;

import com.ItSupport.Models.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur extends Personne {

    @OneToMany(mappedBy = "utilisateur" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}