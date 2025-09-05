package com.vbtech.Bibliotech.Service;

import com.vbtech.Bibliotech.Entity.UsuarioEntity;
import com.vbtech.Bibliotech.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List <UsuarioEntity> ListarUsuarios() {
        if (usuarioRepository.findAll().isEmpty()) {
            throw new RuntimeException("Nenhum usuário cadastrado");
        }
        return usuarioRepository.findAll();
    }
}
