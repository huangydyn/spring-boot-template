package com.huangydyn.base.config;


import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Random;

@Configuration
@ConditionalOnClass({MariaDB4jSpringService.class, DataSource.class})
@EnableConfigurationProperties(DataSourceProperties.class)
public class MariaDB4jConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MariaDB4jSpringService mariaDB4jSpringService() {
        MariaDB4jSpringService mariaDB4jSpringService = new MariaDB4jSpringService();
        DBConfigurationBuilder builder = mariaDB4jSpringService.getConfiguration();
        builder.addArg("--character-set-server=utf8mb4");
        builder.addArg("--collation-server=utf8mb4_general_ci");
        builder.addArg("--lower_case_table_names=1");
        builder.addArg("--user=root");

        //We have to set random port as the different spring context would share
        //the same mariadb instance, maridb could not start if the address
        //is already be in use.
        builder.setPort(new Random().nextInt(1000) + 60000);

        return mariaDB4jSpringService;
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSource dataSource(MariaDB4jSpringService mariaDB4jSpringService,
                                 DataSourceProperties dataSourceProperties) throws ManagedProcessException {
        mariaDB4jSpringService.getDB().createDB(dataSourceProperties.getName());
        DBConfigurationBuilder dBConfiguration = mariaDB4jSpringService.getConfiguration();

        return DataSourceBuilder.create()
                .url(dBConfiguration.getURL(dataSourceProperties.getName()))
                .driverClassName(dataSourceProperties.getDriverClassName())
                .build();
    }
}
