package com.maleca.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maleca.bookstore.domain.Categoria;
import com.maleca.bookstore.dtos.CategoriaDTO;
import com.maleca.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {

		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	
	@PostMapping
	public RequestEntity<Void> create(@RequestBody Categoria obj) {
		obj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		// return RequestEntity.created(uri).build();;
		return RequestEntity.get(uri).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO objDto) {
		Categoria newObj = service.create(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));

	}
	
	/*
	@DeleteMapping (value="/{id}")
	public ResponseEntity <void> delete(@PathVariable Integer id) { 

		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	*/

}
