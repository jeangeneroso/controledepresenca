package com.example.controledepresenca.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TiDbAutoIdConfig implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public TiDbAutoIdConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        // 1. Garante a criação automática das Sequences no TiDB Cloud
        try {
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_lideres START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_colaboradores START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_diaria_colaboradores START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_operacoes START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_aprovacoes START WITH 1 INCREMENT BY 1;");
        } catch (Exception e) {
            System.err.println("Aviso na criação das Sequences: " + e.getMessage());
        }

        // 2. Aplica o incremento unitário (AUTO_ID_CACHE = 1) em todas as tabelas compatíveis
        try {
            List<String> tables = jdbcTemplate.queryForList(
                    "SELECT table_name FROM information_schema.tables WHERE table_schema = DATABASE() AND table_type = 'BASE TABLE'",
                    String.class
            );

            for (String table : tables) {
                try {
                    jdbcTemplate.execute("ALTER TABLE `" + table + "` AUTO_ID_CACHE = 1;");
                } catch (Exception ex) {
                    // Ignora tabelas que já possuem o mecanismo de cache bloqueado nativamente pelo TiDB
                }
            }
        } catch (Exception e) {
            System.err.println("Aviso no ajuste do AUTO_ID_CACHE: " + e.getMessage());
        }
    }
}