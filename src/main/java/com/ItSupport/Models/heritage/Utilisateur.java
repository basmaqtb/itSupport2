package com.ItSupport.Models.heritage;

import com.ItSupport.Models.Enums.Role;
import com.ItSupport.Models.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Setter
@Getter
@Entity
public class Utilisateur extends Personne {

    @OneToMany(mappedBy = "utilisateur" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Utilisateur(Long id,String username, String password, Role role, List<Ticket> tickets) {
        super(id, username, password, role);
        this.tickets = tickets;
        this.setRole(Role.USER);
    }

    public Utilisateur(List<Ticket> tickets) {
        this.tickets = tickets;
        this.setRole(Role.USER);
    }

    public Utilisateur(){
        super();
        this.setRole(Role.USER);
    }
}