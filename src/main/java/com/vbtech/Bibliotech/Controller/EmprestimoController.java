package com.vbtech.Bibliotech.Controller;

import com.vbtech.Bibliotech.Entity.EmprestimoEntity;
import com.vbtech.Bibliotech.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
