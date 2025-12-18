package io.github.boinhaTI.auth_api.dto;

import io.github.boinhaTI.auth_api.enums.EnumRole;

public record UsuarioRequestDto(
        String nome,
        String login,
        String senha,
        EnumRole role
) {
}
