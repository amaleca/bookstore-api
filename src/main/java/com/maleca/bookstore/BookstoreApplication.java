package com.maleca.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maleca.bookstore.domain.Categoria;
import com.maleca.bookstore.domain.Livro;
import com.maleca.bookstore.repositories.CategoriaRepository;
import com.maleca.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication  {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
