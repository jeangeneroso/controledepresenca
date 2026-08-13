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
            List<String> tables = jdbcTemplate.queryForList(
                    "SELECT table_name FROM information_schema.tables WHERE table_schema = DATABASE() AND table_type = 'BASE TABLE'",
                    String.class
            );

            for (String table : tables) {
                jdbcTemplate.execute("ALTER TABLE `" + table + "` AUTO_ID_CACHE = 1");
            }
        } catch (Exception e) {
            // Ignora exceções na inicialização para não travar a subida do servidor
        }
    }
}