package com.example.backend__pasteleria.dto;

// Código JWT inutilizado - ahora usa localStorage
// public record AuthResponse(String token) {}

// Nueva implementación para localStorage
public record AuthResponse(
    String username, 
    boolean isAdmin,
    // Mantener token comentado para futura reactivación
    // String token
    String message
) {}
