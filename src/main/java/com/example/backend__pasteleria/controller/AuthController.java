package com.example.backend__pasteleria.controller;

import com.example.backend__pasteleria.dto.AuthRequest;
import com.example.backend__pasteleria.dto.AuthResponse;
import com.example.backend__pasteleria.entity.User;
import com.example.backend__pasteleria.repository.UserRepository;
import com.example.backend__pasteleria.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // Código JWT inutilizado - ahora usa localStorage
        /*
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        User user = (User) authentication.getPrincipal();
        Set<String> roles = user.getRoles().stream()
                .map(role -> role.name())
                .collect(java.util.stream.Collectors.toSet());

        String token = jwtUtil.generateToken(user.getUsername(), roles);
        return ResponseEntity.ok(new AuthResponse(token));
        */
        
        // Nueva implementación con localStorage (sin JWT)
        try {
            // Autenticación básica sin Spring Security
            User user = userRepository.findByUsername(request.username())
                    .orElse(null);
                    
            if (user != null && passwordEncoder.matches(request.password(), user.getPassword())) {
                boolean isAdmin = user.getRoles().contains(User.Role.ADMIN);
                return ResponseEntity.ok(new AuthResponse(
                    user.getUsername(), 
                    isAdmin, 
                    "Login successful"
                    //, token comentado
                ));
            } else {
                return ResponseEntity.status(401)
                    .body(new AuthResponse(null, false, "Credenciales inválidas"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500)
                .body(new AuthResponse(null, false, "Error en servidor"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRoles(Set.of(User.Role.USER));

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/register-admin")
    public ResponseEntity<String> registerAdmin(@RequestBody AuthRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRoles(Set.of(User.Role.ADMIN));

        userRepository.save(user);
        return ResponseEntity.ok("Admin registered successfully");
    }
}
