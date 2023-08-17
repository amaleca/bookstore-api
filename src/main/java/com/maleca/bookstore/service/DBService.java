package com.maleca.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maleca.bookstore.domain.Categoria;
import com.maleca.bookstore.domain.Livro;
import com.maleca.bookstore.repositories.CategoriaRepository;
import com.maleca.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	
	public void instanciaBaseDeDados() {
		//Instancias de Categorias
				Categoria cat1 = new Categoria(null,"Informatica", "Livro de TI");
				Categoria cat2 = new Categoria(null,"Matematica", "Livro de Mate");
				Categoria cat3 = new Categoria(null,"Portugues", "Livro de Portugues");
				
				//Instanciacao de Livros
				Livro l1 = new Livro(null, "Clean code", "Robert Mart", "Lorem epsum", cat1);
				Livro l2 = new Livro(null, "Codigo limpo", "Roberto Maleca", "Lorem epsum", cat1);
				Livro l3 = new Livro(null, "Portugues", "Alfredo Maleca", "Lorem epsum", cat1);
				Livro l4 = new Livro(null, "Portugues", "Alfredo Maleca", "Lorem epsum", cat2);
				Livro l5 = new Livro(null, "Portugues", "Alfredo Maleca", "Lorem epsum", cat2);
				Livro l6 = new Livro(null, "Portugues", "Alfredo Maleca", "Lorem epsum", cat3);
				Livro l7 = new Livro(null, "Portugues", "Alfredo Maleca", "Lorem epsum", cat3);
				
				
				cat1.getLivros().addAll(Arrays.asList(l1,l2,l3)); 
				cat2.getLivros().addAll(Arrays.asList(l4,l5, l6, l7)); 
				
				this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
				this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6, l7));
	}

}
