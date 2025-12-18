package io.github.boinhaTI.auth_api.service.contratos;

import io.github.boinhaTI.auth_api.dto.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {

    String obterToken(AuthDto authDto);
    String validarToken(String token);
}
