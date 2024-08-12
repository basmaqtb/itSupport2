package com.ItSupport.Services;

import com.ItSupport.DTO.Authen.AuthenticationRequest;
import com.ItSupport.DTO.Authen.AuthenticationResponse;
import com.ItSupport.DTO.Authen.RegisterRequest;
import com.ItSupport.DTO.Authen.TechnicienDTO;
import com.ItSupport.Dao.AdminRepository;
import com.ItSupport.Dao.TechnicienRepository;
import com.ItSupport.Dao.UserRepository;
import com.ItSupport.Mappers.AdminMapper;
import com.ItSupport.Mappers.PersoneMapper;
import com.ItSupport.Mappers.TechnicienMapper;
import com.ItSupport.Mappers.UserMapper;
import com.ItSupport.Models.Enums.Role;
import com.ItSupport.Models.heritage.Admin;
import com.ItSupport.Models.heritage.Personne;
import com.ItSupport.Models.heritage.Technicien;
import com.ItSupport.Models.heritage.Utilisateur;
import com.ItSupport.exception.RegistrationException;
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

    private final UserRepository userdao;
    private final AdminRepository admindao;
    private final TechnicienRepository techniciendao;
    private final UserMapper userMapper;
    private final TechnicienMapper technicienMapper;
    private final AdminMapper adminMapper;
    private final PersoneMapper personeMapper;
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

        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerUser(RegisterRequest request) {

        var user = Utilisateur.builder()
                .username(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {

        var admin = Admin.builder()
                .username(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        admindao.save(admin);

        var jwtToken = jwtService.generateToken(admin);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerTechnicien(RegisterRequest request) {

        if (userRepository.findByUsername(request.getName()).isPresent()) {
            throw new RegistrationException();
        }
        var technician = technicienMapper.toEntity(request);
        technician.setPassword(passwordEncoder.encode(request.getPassword()));
        technician.setAvailability(true);
        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(technicienMapper.toDto(techniciendao.save(technician))))
                .build();



}