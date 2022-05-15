package com.thecodeschool.security.controller;

import com.thecodeschool.security.model.AuthenticationRequest;
import com.thecodeschool.security.model.AuthenticationResponse;
import com.thecodeschool.security.service.UserDetailsServiceImpl;
import com.thecodeschool.security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new RuntimeException("Username or password is invalid.");
        }
        String jwt = jwtUtils.generateToken(myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername()));
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
