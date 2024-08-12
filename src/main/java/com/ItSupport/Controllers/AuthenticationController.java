package com.ItSupport.Controllers;

import com.ItSupport.DTO.Authen.AuthenticationRequest;
import com.ItSupport.DTO.Authen.AuthenticationResponse;
import com.ItSupport.DTO.Authen.RegisterRequest;
import com.ItSupport.Models.heritage.Utilisateur;
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


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/signup/u")
    public ResponseEntity<AuthenticationResponse> signUpUser(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.registerUser(request));

    }
    @PostMapping("/signup/a")
    public ResponseEntity<AuthenticationResponse> signUpAdmn(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.registerAdmin(request));

    }
    @PostMapping("/signup/t")
    public ResponseEntity<AuthenticationResponse> signUpTechnicien(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.registerTechnicien(request));

    }

}