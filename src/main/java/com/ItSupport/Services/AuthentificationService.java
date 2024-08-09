package com.ItSupport.Services;

import com.ItSupport.DTO.Authen.AuthenticationRequest;
import com.ItSupport.DTO.Authen.AuthenticationResponse;
import com.ItSupport.Dao.AdminRepository;
import com.ItSupport.Dao.TechnicienRepository;
import com.ItSupport.Dao.UserRepository;
import com.ItSupport.Models.heritage.Admin;
import com.ItSupport.Models.heritage.Technicien;
import com.ItSupport.Models.heritage.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthentificationService {

    private final UserRepository userRepository;

    private final UserRepository userdao;
    private final AdminRepository admindao;
    private final TechnicienRepository techniciendao;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userdao.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public List<Utilisateur> getAllUser(){
        return userdao.findAll();
    }

    public void deleteCompte(long id_user) {
        userdao.deleteById(id_user);
    }

    public Long count(){
        return userdao.count();
    }

    public AuthenticationResponse registerUser(AuthenticationRequest request) {
      Utilisateur utilisateur = new Utilisateur();
      utilisateur.setUsername(request.getUsername());
      utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));
      userRepository.save(utilisateur);
      return null;
    }
    public AuthenticationResponse registerAdmin(AuthenticationRequest request) {
        Admin admin = new Admin();
        admin.setUsername(request.getUsername());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admindao.save(admin);
        return null;
    }
    public AuthenticationResponse registerTechnicien(AuthenticationRequest request) {
        Technicien technicien = new Technicien();
        technicien.setUsername(request.getUsername());
        technicien.setPassword(passwordEncoder.encode(request.getPassword()));
        techniciendao.save(technicien);
        return null;
    }
}
