package com.example.demo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class App1DaoImpl implements App1Dao {

    @Override
    public String addAccount() {
        System.out.println("Add account operation in App1DAO");
        return "test";
    }

}
