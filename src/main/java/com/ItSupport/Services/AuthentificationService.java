package com.ItSupport.Services;

import com.ItSupport.DTO.Authen.AuthenticationRequest;
import com.ItSupport.DTO.Authen.AuthenticationResponse;
import com.ItSupport.DTO.Authen.RegistreRequest;
import com.ItSupport.Dao.AdminRepository;
import com.ItSupport.Dao.PersonneRepository;
import com.ItSupport.Dao.TechnicienRepository;
import com.ItSupport.Dao.UserRepository;
import com.ItSupport.Models.Enums.Role;
import com.ItSupport.Models.heritage.Admin;
import com.ItSupport.Models.heritage.Personne;
import com.ItSupport.Models.heritage.Technicien;
import com.ItSupport.Models.heritage.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthentificationService {

    private final UserRepository userRepository;
    private final PersonneRepository personneRepository;

    private final UserRepository userdao;
    private final AdminRepository admindao;
    private final TechnicienRepository techniciendao;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var personne = personneRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(personne);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }



//    public AuthenticationResponse registerUser(AuthenticationRequest request) {
//      Utilisateur utilisateur = new Utilisateur();
//      utilisateur.setUsername(request.getUsername());
//      utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));
//      userRepository.save(utilisateur);
//      return null;
//    }
//    public AuthenticationResponse registerAdmin(AuthenticationRequest request) {
//        Admin admin = new Admin();
//        admin.setUsername(request.getUsername());
//        admin.setPassword(passwordEncoder.encode(request.getPassword()));
//        admindao.save(admin);
//        return null;
//    }
//    public AuthenticationResponse registerTechnicien(AuthenticationRequest request) {
//        Technicien technicien = new Technicien();
//        technicien.setUsername(request.getUsername());
//        technicien.setPassword(passwordEncoder.encode(request.getPassword()));
//        techniciendao.save(technicien);
//        return null;
//    }

    public AuthenticationResponse register(RegistreRequest request, Role role) {

        Personne personne;
        if (role == Role.TECHNICIEN) {
            personne = new Technicien();
        } else if(role == Role.USER){
            personne = new Utilisateur();
        }else{
            personne = new Admin();

        }

        personne.setFullname(request.getFullname());
        personne.setEmail(request.getEmail());
        personne.setPassword(passwordEncoder.encode(request.getPassword()));
        personne.setRole(role);

        personneRepository.save(personne);
        String jwtToken = jwtService.generateToken(personne);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );

        var user = personneRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
