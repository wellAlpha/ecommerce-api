package com.alpha.bookStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.bookStore.entities.Autor;
import com.alpha.bookStore.repositories.AutorRepository;

@RestController
@RequestMapping("/api/bookstore/admin/autor")
public class AutorControllerAPI {
	@Autowired
	AutorRepository autorRepository;

	@GetMapping("/list")
	public List<Autor> list() {
		return autorRepository.findAll();
	}

	@PostMapping("/create")
	public Autor create(@RequestBody Autor autor) {
		return autorRepository.save(autor);
	}

	@PutMapping("/update/{id}")
	public Autor update(@PathVariable Integer id, @RequestBody Autor autor) {
		var oldAutor = autorRepository.findById(id).get();
		
		oldAutor.setNome(autor.getNome());
		
		return autorRepository.save(oldAutor);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		var autor = autorRepository.findById(id).get();

		autor.setAtivo(false);
		
		autorRepository.save(autor);
	}
}
