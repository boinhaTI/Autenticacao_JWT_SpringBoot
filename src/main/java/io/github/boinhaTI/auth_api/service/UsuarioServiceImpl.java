package io.github.boinhaTI.auth_api.service;

import io.github.boinhaTI.auth_api.dto.UsuarioRequestDto;
import io.github.boinhaTI.auth_api.dto.UsuarioResponseDto;
import io.github.boinhaTI.auth_api.enums.EnumRole;
import io.github.boinhaTI.auth_api.model.Usuario;
import io.github.boinhaTI.auth_api.repository.UsuariosRepository;
import io.github.boinhaTI.auth_api.service.contratos.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuariosRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseDto salvar(UsuarioRequestDto usuarioRequestDto) {

        if (repository.findByLogin(usuarioRequestDto.login()) != null) {
            throw new RuntimeException("Usuário já cadastrado");
        }
        var passwordHash = passwordEncoder.encode(usuarioRequestDto.senha());
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDto.nome());
        usuario.setLogin(usuarioRequestDto.login());
        usuario.setSenha(passwordHash);
        usuario.setRole(EnumRole.USER);
        repository.save(usuario);
        return toResponse(usuario);
    }
    public UsuarioResponseDto toResponse(Usuario usuario) {
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getLogin()
        );
    }
}
