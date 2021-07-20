package com.acme.noteservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class NoteserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(NoteserviceApplication.class, args);
	}

}
