package com.template.config;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author: guoqing.chen01@hand-china.com 2021-08-30 15:04
 **/

//@Configuration
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    /*@Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }*/

    @Bean
    public DataSource dataSource() throws URISyntaxException {

        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        logger.info("{}",dbUri);
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];

        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        System.out.println("userDBDatasource :: init");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        logger.info("jdbc -url:{} -driverClassName:{} -username:{} -password:{}",dataSource.getUrl(),dataSource.getClass(),dataSource.getUsername(),dataSource.getPassword());
        return dataSource;
    }
}
