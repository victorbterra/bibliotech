package com.vbtech.Bibliotech.Service;


import com.vbtech.Bibliotech.Entity.LivroEntity;
import com.vbtech.Bibliotech.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroEntity salvarLivro(LivroEntity livro){
        if(livro.getTitulo() == null || livro.getTitulo().isEmpty()){
            throw new IllegalArgumentException("O título do livro não pode ser vazio");
        }
        if(livro.getAutor() == null || livro.getAutor().isEmpty()){
            throw new IllegalArgumentException("O autor do livro não pode ser vazio");
        }
        if(livro.getIsbn() == null || livro.getIsbn().isEmpty()){
            throw new IllegalArgumentException("O ISBN do livro não pode ser vazio");
        }
        if(livro.getAnoPublicacao() <= 0){
            throw new IllegalArgumentException("O ano de publicação do livro deve ser um número positivo");
        }
        return livroRepository.save(livro);
    }

    public List<LivroEntity> listarLivros() {
       return livroRepository.findAll();
    }

    public LivroEntity buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
    }


}
