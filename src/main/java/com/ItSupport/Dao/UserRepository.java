package com.ItSupport.Dao;

import com.ItSupport.Models.heritage.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {

}
