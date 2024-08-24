package tech.orm.springboot_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication (exclude = HibernateJpaAutoConfiguration.class)
public class SpringbootHibernateApplication {

  public static void main (String[] args) {
    SpringApplication.run (SpringbootHibernateApplication.class, args);
  }

}
