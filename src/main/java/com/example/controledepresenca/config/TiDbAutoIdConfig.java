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
        try {
            // 1. Garante a criação automática das Sequences usadas nas anotações @SequenceGenerator
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_lideres START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_colaboradores START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_diaria_colaboradores START WITH 1 INCREMENT BY 1;");
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS seq_operacoes START WITH 1 INCREMENT BY 1;");

            // 2. Mantém o ajuste de cache para tabelas que usarem AUTO_INCREMENT
            List<String> tables = jdbcTemplate.queryForList(
                    "SELECT table_name FROM information_schema.tables WHERE table_schema = DATABASE() AND table_type = 'BASE TABLE'",
                    String.class
            );

            for (String table : tables) {
                jdbcTemplate.execute("ALTER TABLE `" + table + "` AUTO_ID_CACHE = 1");
            }
        } catch (Exception e) {
            System.err.println("Aviso na inicialização do TiDB: " + e.getMessage());
        }
    }
}