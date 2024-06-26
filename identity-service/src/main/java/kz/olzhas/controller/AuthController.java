package kz.olzhas.controller;

import kz.olzhas.dto.AuthRequest;
import kz.olzhas.entity.UserCredential;
import kz.olzhas.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
    @GetMapping("/token-user")
    public ResponseEntity<?> getUserByToken(@RequestParam("token") String token) {
        return ResponseEntity.ok(service.getUserIdByToken(token));
    }

    @GetMapping("/by-us erId")
    public ResponseEntity<?> getUserByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(service.getUserByUserId(userId));
    }
}
