package org.timosha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.timosha.service.AuthenticationService;
import org.timosha.config.JwtAuthenticationResponse;
import org.timosha.model.SignInRequest;
import org.timosha.model.SignUpRequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/reg")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
        return authenticationService.signUp(request);
    }
    @GetMapping("/reg")
    public String signIn(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        return "reg";
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }
    @GetMapping("/login")
    public String signIn(@RequestParam String username, @RequestParam String password) {
        return "login";
    }

}
