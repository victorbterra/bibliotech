package com.vbtech.Bibliotech.Controller;

import com.vbtech.Bibliotech.Entity.UsuarioEntity;
import com.vbtech.Bibliotech.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioEntity> salvarUsuario(@RequestBody UsuarioEntity usuario){
            UsuarioEntity novoUsuario = usuarioService.criarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorId(@PathVariable Long id){
            UsuarioEntity usuario = usuarioService.obterUsuarioPorId(id);
            return ResponseEntity.ok(usuario);
    }

    @GetMapping ResponseEntity<List<UsuarioEntity>> listarUsuarios(){
            List<UsuarioEntity> usuarios = usuarioService.ListarUsuarios();
            return ResponseEntity.ok(usuarios);
    }
}
