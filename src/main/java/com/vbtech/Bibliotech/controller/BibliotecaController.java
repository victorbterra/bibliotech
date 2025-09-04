package com.vbtech.Bibliotech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BibliotecaController {

    @GetMapping("/meescuta")
    public String ping() {
        return "Estou ouvindo !";
    }

}
