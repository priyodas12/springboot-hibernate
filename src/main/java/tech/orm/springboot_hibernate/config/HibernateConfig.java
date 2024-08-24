package tech.orm.springboot_hibernate.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Configuration
public class HibernateConfig {

  @Value ("${spring.datasource.url}")
  private String url;
  @Value ("${spring.datasource.driver-class-name}")
  private String driverClassName;
  @Value ("${spring.jpa.hibernate.ddl-auto}")
  private String ddlStatus;
  @Value ("${spring.datasource.username:postgres}")
  private String username;
  @Value ("${spring.datasource.password:priyo123}")
  private String password;
  @Value ("${spring.jpa.properties.hibernate.dialect}")
  private String dialect;

  //create entity manager
  @Bean (name = "entityManagerFactory")
  public LocalSessionFactoryBean sessionFactory () {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean ();
    factory.setDataSource (getDataSource ());
    factory.setHibernateProperties (getHibernateProperties ());
    factory.setPackagesToScan ("tech.orm.springboot_hibernate.model");

    log.info ("Hibernate SessionFactory:: {}", factory);
    return factory;
  }


  //create datasource
  @Bean
  public DataSource getDataSource () {
    DriverManagerDataSource dataSource = new DriverManagerDataSource (url, username, password);
    dataSource.setDriverClassName (driverClassName);

    log.info ("Hibernate Datasource:: {}", dataSource);
    return dataSource;
  }

  //extract properties
  private Properties getHibernateProperties () {
    Properties properties = new Properties ();
    properties.put (Environment.DIALECT, dialect);
    properties.put (Environment.HBM2DDL_AUTO, ddlStatus);
    properties.put (Environment.SHOW_SQL, "true");
    properties.put (Environment.FORMAT_SQL, "true");

    log.info ("Hibernate Properties:: {}", properties);

    return properties;
  }

  //create Transaction manager
  @Bean
  @Autowired
  public PlatformTransactionManager transactionManager (SessionFactory sessionFactory) {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager ();
    transactionManager.setSessionFactory (sessionFactory);
    return transactionManager;
  }
}
