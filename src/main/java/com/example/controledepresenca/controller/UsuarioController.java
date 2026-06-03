package com.example.controledepresenca.controller;

import com.example.controledepresenca.model.Usuario;
import com.example.controledepresenca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class UsuarioController {

   @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario dadosLogin) {
        // 1. Procura o usuário no banco de dados
        Optional<Usuario> usuarioBanco = usuarioRepository.findByUsuario(dadosLogin.getUsuario());

        // 2. Se o usuário existir, checa a senha
        if (usuarioBanco.isPresent()) {
            // ATENÇÃO: Aqui estamos comparando texto puro de forma simples para teste.
            // No futuro, usaremos o BCrypt para comparar as senhas criptografadas!
            if (usuarioBanco.get().getSenha().equals(dadosLogin.getSenha())) {
                return ResponseEntity.ok("{\"mensagem\": \"Login efetuado com sucesso!\"}");
            }
        }

        // 3. Se o usuário não existir ou a senha estiver errada, nega o acesso
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("{\"erro\": \"Usuário ou senha inválidos.\"}");
    }
}
