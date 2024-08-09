package com.ItSupport.Services;

import com.ItSupport.Dao.UserRepository;
import com.ItSupport.Models.heritage.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return userRepository.findAll();
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return userRepository.save(utilisateur);
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return userRepository.findById(id);
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur updatedUtilisateur) {
        return userRepository.findById(id)
                .map(utilisateur -> {
                    utilisateur.setNom(updatedUtilisateur.getNom());
                    utilisateur.setEmail(updatedUtilisateur.getEmail());
                    // Mettez à jour les autres champs
                    return userRepository.save(utilisateur);
                })
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec ID : " + id));
    }

    public void deleteUtilisateur(Long id) {
        userRepository.deleteById(id);
    }
}
