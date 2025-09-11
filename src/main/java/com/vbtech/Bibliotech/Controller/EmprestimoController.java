package com.vbtech.Bibliotech.Controller;

import com.vbtech.Bibliotech.Entity.EmprestimoEntity;
import com.vbtech.Bibliotech.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<EmprestimoEntity> realizarEmprestimo(@RequestParam Long usuarioId, @RequestParam Long livroId){
            EmprestimoEntity emprestimo = emprestimoService.realizarEmprestimo(usuarioId, livroId);
            return ResponseEntity.ok(emprestimo);
    }

    @PutMapping("/{emprestimoId}/devolver")
    public ResponseEntity<EmprestimoEntity> realizarDevolucao(@PathVariable Long emprestimoId){
        EmprestimoEntity emprestimo = emprestimoService.realizarDevolucao(emprestimoId);
        return new ResponseEntity<>(emprestimo, HttpStatus.OK);
    }
}
