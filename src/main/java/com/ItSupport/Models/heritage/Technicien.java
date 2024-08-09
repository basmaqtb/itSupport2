package com.ItSupport.Models.heritage;

import com.ItSupport.Models.Enums.Role;
import com.ItSupport.Models.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Technicien extends Personne {

    @OneToMany(mappedBy = "technicien" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Technicien(Long id, String nom, String username, String password, Role role, List<Ticket> tickets) {
        super(id, nom, username, password, role);
        this.tickets = tickets;
        this.setRole(Role.TECHNICIEN);
    }

    public Technicien(List<Ticket> tickets) {
        this.tickets = tickets;
        this.setRole(Role.USER);
    }

    public Technicien(){
        super();
        this.setRole(Role.TECHNICIEN);
    }
}
