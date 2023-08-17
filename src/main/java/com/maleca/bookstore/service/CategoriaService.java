package com.maleca.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.maleca.bookstore.domain.Categoria;
import com.maleca.bookstore.dtos.CategoriaDTO;
import com.maleca.bookstore.repositories.CategoriaRepository;
import com.maleca.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto nao encontrado! id:" + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria create (Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
		
	}

	public Categoria create(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
		
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	
	}

}
