package com.thecodeschool.security.controller;

import com.thecodeschool.security.model.AuthErrorResponse;
import com.thecodeschool.security.model.AuthRequest;
import com.thecodeschool.security.model.AuthResponse;
import com.thecodeschool.security.model.AuthSuccessResponse;
import com.thecodeschool.security.service.UserDetailsServiceImpl;
import com.thecodeschool.security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl myUserDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authenticationRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );

            if (authentication.isAuthenticated()) {
                String jwt = jwtUtils.generateToken(myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername()));
                return ResponseEntity.ok(new AuthSuccessResponse(jwt));
            }
        } catch (BadCredentialsException ex) {
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(new AuthErrorResponse("Invalid credentials"));
        }
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(new AuthErrorResponse("Invalid credentials"));
    }
}
