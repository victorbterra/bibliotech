package com.vbtech.Bibliotech.Controller;

import com.vbtech.Bibliotech.Entity.LivroEntity;
import com.vbtech.Bibliotech.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroEntity> adicionarLivro(@RequestBody LivroEntity livro) {
        try {
            LivroEntity livroSalvo = livroService.salvarLivro(livro);
            return ResponseEntity.ok(livroSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
