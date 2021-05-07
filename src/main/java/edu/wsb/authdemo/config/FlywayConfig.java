package edu.wsb.authdemo.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig  {

    public FlywayConfig(DataSource dataSource) {
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }
}
