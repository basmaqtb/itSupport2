package com.ItSupport.Controllers;

import com.ItSupport.DTO.Authen.AuthenticationRequest;
import com.ItSupport.DTO.Authen.AuthenticationResponse;
import com.ItSupport.DTO.Authen.RegistreRequest;
import com.ItSupport.Models.Enums.Role;
import com.ItSupport.Services.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthentificationService authService;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/signup/u")
    public ResponseEntity<AuthenticationResponse> signUpUser(
            @RequestBody RegistreRequest request
    ){
        return ResponseEntity.ok(authService.register(request, Role.USER));

    }

    @PostMapping("/signup/a")
    public ResponseEntity<AuthenticationResponse> signUpAdmin(
            @RequestBody RegistreRequest request
    ){
        return ResponseEntity.ok(authService.register(request, Role.ADMIN));

    }

    @PostMapping("/signup/t")
    public ResponseEntity<AuthenticationResponse> signUpTechnicien(
            @RequestBody RegistreRequest request
    ){
        return ResponseEntity.ok(authService.register(request, Role.TECHNICIEN));

    }

}