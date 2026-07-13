package dev.atis007.orbit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Map;

@RestController

public class PingController {
    private final JdbcTemplate jdbcTemplate;

    public PingController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/ping")
    public Map<String, Object> ping() {
        Integer dbCheck = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        return Map.of("status", "ok", "dbCheck", dbCheck);
    }
}
