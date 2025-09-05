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
        try {
            UsuarioEntity novoUsuario = usuarioService.criarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorId(@PathVariable Long id){
        try {
            UsuarioEntity usuario = usuarioService.obterUsuarioPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping ResponseEntity<List<UsuarioEntity>> listarUsuarios(){
        try {
            List<UsuarioEntity> usuarios = usuarioService.ListarUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
