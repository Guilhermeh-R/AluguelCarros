package com.example.aluguel.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class login {

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String senha) {
        if (usuario.equals("admin") && senha.equals("admin")) {
            return "Login bem-sucedido!";
        } else {
            return "Usuário ou senha inválidos!";
            }
        }
}
