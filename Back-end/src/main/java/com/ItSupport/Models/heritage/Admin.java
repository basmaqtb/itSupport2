package com.ItSupport.Models.heritage;

import com.ItSupport.Models.Enums.Role;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin extends Personne {
    public Admin(Long id, String nom, String username, String password, Role role) {
        super(id, nom, username, password, role);
        this.setRole(Role.ADMIN);
    }

    public Admin() {
        this.setRole(Role.ADMIN);
    }
}
