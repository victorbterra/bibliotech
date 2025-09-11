package com.vbtech.Bibliotech.Service;


import com.vbtech.Bibliotech.Entity.EmprestimoEntity;
import com.vbtech.Bibliotech.Entity.LivroEntity;
import com.vbtech.Bibliotech.Entity.UsuarioEntity;
import com.vbtech.Bibliotech.Repository.EmprestimoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private LivroService livroService;


    @Transactional
    public EmprestimoEntity realizarEmprestimo(Long usuarioId, Long livroId){
        UsuarioEntity usuario = usuarioService.obterUsuarioPorId(usuarioId);
        LivroEntity livro = livroService.buscarPorId(livroId);
        //logica para verificar se o livro está disponível
        if (!"DISPONIVEL".equals(livroService.buscarPorId(livroId).getStatus())) {
            throw new RuntimeException("Livro não está disponível para empréstimo.");
        }
        // atualiza o status do livro para "EMPRESTADO"
        livro.setStatus("EMPRESTADO");

        EmprestimoEntity novoEmprestimo = new EmprestimoEntity();
        novoEmprestimo.setUsuario(usuario);
        novoEmprestimo.setLivro(livro);

        novoEmprestimo.setDataEmprestimo(LocalDate.now());
        novoEmprestimo.setDataDevolucao(LocalDate.now().plusDays(14));

        return emprestimoRepository.save(novoEmprestimo);
    }

    @Transactional
    public EmprestimoEntity realizarDevolucao(Long emprestimoId) {
        EmprestimoEntity emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com ID: " + emprestimoId));
        if(emprestimo.getDataDevolucaoReal()!=null){
            throw new RuntimeException("Este empréstimo já foi devolvido.");
        }

        LivroEntity livro = emprestimo.getLivro();
        livro.setStatus("DISPONIVEL");
        emprestimo.setDataDevolucaoReal(LocalDate.now());
        return emprestimo;

    }
}
