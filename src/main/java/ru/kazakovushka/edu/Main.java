package ru.kazakovushka.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.BadSqlGrammarException;

import java.sql.SQLException;

@SpringBootApplication
@ImportResource("beans.xml")
public class Main implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    public void run(String... args) throws Exception {
        ProductUtils productUtils = applicationContext.getBean(ProductUtils.class);
        try {
            productUtils.addTwo();
        }catch (BadSqlGrammarException ex){
            System.out.println(ex.fillInStackTrace());
        }
        productUtils.print();
        System.out.println(productUtils.getClass());
    }
}
