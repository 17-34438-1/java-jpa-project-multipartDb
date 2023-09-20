package com.example.multipleds.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory",
        basePackages = {"com.example.multipleds.Repository.oracle"}, transactionManagerRef = "oracleTransactionManager")
public class OracleDBConfig {

    @Bean(name = "oracleDatasource")
    @ConfigurationProperties(prefix = "spring.oracle.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("oracleDatasource") DataSource dataSource){

        Map<String,Object> properties = new HashMap<>();

        return builder.dataSource(dataSource).properties(properties)
                .packages("com.example.multipleds.Model.oracle").persistenceUnit("Oracle").build();

    }

    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("oracleEntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}
