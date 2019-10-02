package ru.kazakovushka.edu;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public class ProductUtils {
    JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addNew(String name, Double price){
        jdbcTemplate.update("INSERT INTO Product VALUES(?,?)", name, price);
    }

    public void causeException(){
        jdbcTemplate.update("INSERT INTO Products");
    }

   // @Transactional
    public void addTwo(){
        addNew("Milk", 30d);
        causeException();
        addNew("Eggs", 5.6);
    }

    public void print(){
        for (Map<String, Object> product :jdbcTemplate.queryForList("SELECT * FROM Product")){
            System.out.println("product: " + product.get("name") + " " + product.get("price"));
        }
    }
}
