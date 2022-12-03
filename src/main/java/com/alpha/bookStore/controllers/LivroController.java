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

import com.alpha.bookStore.entities.Categoria;
import com.alpha.bookStore.entities.Livro;
import com.alpha.bookStore.repositories.LivroRepository;
import com.alpha.bookStore.services.LivroService;

@RestController
@RequestMapping("/api/bookstore/admin/livro")
public class LivroController {
	@Autowired
	LivroService livroService;
	
	@GetMapping("/list")
	public List<Livro> list (){
		return livroService.list();
	}
	
	@PostMapping("/create")
	public Livro create(@RequestBody Livro livro) {
		return livroService.create(livro);
	}
	
	@PutMapping("/update")
	public Livro update(@RequestBody Livro livro) {
		return livroService.update(livro);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {		
		livroService.delete(id);
	}
}
