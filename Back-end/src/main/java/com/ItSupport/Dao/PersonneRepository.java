package com.ItSupport.Dao;

import com.ItSupport.Models.Enums.Role;
import com.ItSupport.Models.heritage.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
    Optional<Personne> findByEmail(String email);
    List<Personne> findByRole(Role role);
}
