package io.github.boinhaTI.auth_api.controller;


import io.github.boinhaTI.auth_api.dto.UsuarioRequestDto;
import io.github.boinhaTI.auth_api.dto.UsuarioResponseDto;
import io.github.boinhaTI.auth_api.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvar(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto response = service.salvar(usuarioRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public String reposta() {
        return "Hello World";
    }
}
