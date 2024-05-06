package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DAO.App1Dao;
import com.example.demo.DAO.AppDao;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao, App1Dao app1Dao) {
		return runner -> {
			addAccount(appDao, app1Dao);
		};
	}

	private void addAccount(AppDao appDao, App1Dao app1Dao) {
		appDao.addAccount();
		appDao.setId(100);
		appDao.setName("testing");
		appDao.getId();
		appDao.getName();
		appDao.getData("input");
		appDao.getInfo("input");
	}

}
