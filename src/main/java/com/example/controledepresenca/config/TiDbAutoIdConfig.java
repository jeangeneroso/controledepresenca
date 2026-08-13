package com.example.controledepresenca.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TiDbAutoIdConfig implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public TiDbAutoIdConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        try {
            // 1. Configura o TiDB globalmente/sessão para não dar salto de IDs em NENHUMA tabela AUTO_INCREMENT
            jdbcTemplate.execute("SET GLOBAL tidb_allow_remove_auto_inc = ON;");
            jdbcTemplate.execute("SET @@auto_increment_increment = 1;");

            // 2. Garante a criação de todas as Sequences
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_lideres START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_colaboradores START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_diaria_colaboradores START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_operacoes START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_aprovacoes START WITH 1 INCREMENT BY 1;");

        } catch (Exception e) {
            System.err.println("Aviso na inicialização do TiDB: " + e.getMessage());
        }
    }
}