package io.github.boinhaTI.auth_api.service.contratos;

import io.github.boinhaTI.auth_api.dto.UsuarioRequestDto;
import io.github.boinhaTI.auth_api.dto.UsuarioResponseDto;

public interface UsuarioService {

    UsuarioResponseDto salvar(UsuarioRequestDto usuarioRequestDto);
}
