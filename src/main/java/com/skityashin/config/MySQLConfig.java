package com.skityashin.config;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Class {@link MySQLConfig} for data base configuration
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 19.01.17
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.skityashin"})

public class MySQLConfig {
    private static final Logger LOG = Logger.getLogger(MySQLConfig.class);

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.skityashin.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("skityashin");
        Properties properties = new Properties();
        properties.put("minPoolSize", "1");
        properties.put("maxPoolSize", "100");
        properties.put("breakAfterAcquireFailure", "false");
        properties.put("acquireRetryAttempts", "3");
        properties.put("idleConnectionTestPeriod", "300");
        properties.put("testConnectionOnCheckout", "true");
        dataSource.setConnectionProperties(properties);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource());
        try {
            return template;
        } finally {
            LOG.info("jdbcTemplate initialized");
        }
    }

    @Bean
    @Autowired
    public HibernateTemplate hibernateTemplate(SessionFactory s) {
        try {
            return new HibernateTemplate(s);
        } finally {
            LOG.info("hibernateTemplate initialized");
        }
    }

    @Bean
    @Autowired
    public DataSourceTransactionManager dataSourceTransactionManager() {
        final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(dataSourceTransactionManager());
        return transactionTemplate;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("jadira.usertype.autoRegisterUserTypes", "true");
        hibernateProperties.setProperty("org.hibernate.flushMode", "auto");
        hibernateProperties.setProperty("hibernate.cache.use_minimal_puts", "true");
        return hibernateProperties;
    }
}
