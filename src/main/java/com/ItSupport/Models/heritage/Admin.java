package com.ItSupport.Models.heritage;

import com.ItSupport.Models.Enums.Role;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@Entity
public class Admin extends Personne {
    public Admin(Long id, String username, String password, Role role) {
        super(id, username, password, role);
        this.setRole(Role.ADMIN);
    }

    public Admin() {
        this.setRole(Role.ADMIN);
    }
}
