package com.example.demo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl implements AppDao {

    private int id;
    private String name;

    @Override
    public void addAccount() {
        System.out.println("Add account operation in AppDAO");
    }

    public int getId() {
        System.out.println("get id");
        return this.id;
    }

    public void setId(int id) {
        System.out.println("set id");
        this.id = id;
    }

    public String getName() {
        System.out.println("get name");
        return this.name;
    }

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    @Override
    public String getData(String arg) {
        System.out.println("get data call");
        return "data";
    }

    @Override
    public String getInfo(String arg) {
        System.out.println("get info call");
        return "info";
    }

}
