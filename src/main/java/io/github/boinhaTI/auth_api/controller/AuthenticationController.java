package io.github.boinhaTI.auth_api.controller;

import io.github.boinhaTI.auth_api.dto.AuthDto;
import io.github.boinhaTI.auth_api.service.contratos.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public String authentication(@RequestBody AuthDto authDto) {

        var usuarioAuthentication = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.senha());
        authenticationManager.authenticate(usuarioAuthentication);
        return authenticationService.obterToken(authDto);
    }
}
