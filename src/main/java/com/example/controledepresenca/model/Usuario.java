package com.example.controledepresenca.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuarios") // Nome da tabela no banco de dados
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true, length = 25)
        private String usuario; // O login/username do usuário (não pode repetir no banco)

        @Column(nullable = false, length = 10)
        private String senha; // A senha (que ficará criptografada)

        // Construtor padrão obrigatório do JPA
        public Usuario() {}

        // Construtor completo
        public Usuario(Long id, String usuario, String senha) {
            this.id = id;
            this.usuario = usuario;
            this.senha = senha;
        }

        // Getters e Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getUsuario() { return usuario; }
        public void setUsuario(String usuario) { this.usuario = usuario; }

        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }
    }

