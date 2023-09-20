package com.example.multipleds.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(entityManagerFactoryRef = "commonN4EntityManagerFactory",
        basePackages = {"com.example.multipleds.Repository.commonN4"},transactionManagerRef = "commonN4TransactionManager")
public class CommonN4DBConfig {

    @Bean(name = "commonN4Datasource")
    @ConfigurationProperties(prefix = "spring.common.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "commonN4EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("commonN4Datasource") DataSource dataSource){

        Map<String,Object> properties = new HashMap<>();
        //properties.put("hibernate.hbm2ddl.auto", "update");
        //properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL5Dialect");

        return builder.dataSource(dataSource).properties(properties)
                .packages("com.example.multipleds.Model.commonN4").persistenceUnit("Common").build();

    }

    @Bean(name = "commonN4TransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("commonN4EntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}
