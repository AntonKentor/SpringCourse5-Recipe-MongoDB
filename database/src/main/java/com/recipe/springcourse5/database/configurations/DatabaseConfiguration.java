package com.recipe.springcourse5.database.configurations;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${liquibase.context}")
    private String liquibaseContext;
    @Value("${spring.liquibase.change-log}")
    private String changeLogFile;
    @Value("${liquibase.shouldRun}")
    private boolean liquibaseShouldRun;
    @Value("${spring.liquibase.drop-first}")
    private boolean liquibaseDropFirst;

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setContexts(liquibaseContext);
        springLiquibase.setChangeLog(changeLogFile);
        springLiquibase.setShouldRun(liquibaseShouldRun);
        springLiquibase.setDropFirst(liquibaseDropFirst);
        return springLiquibase;
    }
}