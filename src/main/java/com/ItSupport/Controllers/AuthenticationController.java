package com.ItSupport.Controllers;

import com.ItSupport.DTO.Authen.AuthenticationRequest;
import com.ItSupport.DTO.Authen.AuthenticationResponse;
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

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUpUser(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.registerUser(request));

    }
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUpAdmn(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.registerUser(request));

    }
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUpTechnicien(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.registerUser(request));

    }

}