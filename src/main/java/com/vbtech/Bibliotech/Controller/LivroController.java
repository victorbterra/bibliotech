package com.vbtech.Bibliotech.Controller;
import com.vbtech.Bibliotech.Entity.LivroEntity;
import com.vbtech.Bibliotech.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<List<LivroEntity>> listarLivros() {
        List <LivroEntity> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LivroEntity> buscarLivroPorId(@PathVariable Long id) {
        LivroEntity livro = livroService.buscarPorId(id);
        return ResponseEntity.ok(livro);
    }

    @GetMapping(value = "/search", params = "titulo")
    public ResponseEntity<List<LivroEntity>> buscarLivroPorTitulo(@RequestParam String titulo) {
        List<LivroEntity> livro = livroService.buscarPorTitulo(titulo);
        return ResponseEntity.ok(livro);
    }

    @GetMapping(value = "/search", params = "autor")
    public ResponseEntity<List<LivroEntity>> buscarLivroPorAutor(@RequestParam String autor) {
        List<LivroEntity> livro = livroService.buscarPorAutor(autor);
        return ResponseEntity.ok(livro);
    }
}
