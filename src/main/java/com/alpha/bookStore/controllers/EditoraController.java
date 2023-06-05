package com.alpha.bookStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.bookStore.entities.Autor;
import com.alpha.bookStore.entities.Editora;
import com.alpha.bookStore.repositories.AutorRepository;
import com.alpha.bookStore.repositories.EditoraRepository;
import com.alpha.bookStore.services.EditoraService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookstore/admin/editora")
public class EditoraController {
	@Autowired
	EditoraService editoraService;

	@GetMapping("/list")
	public List<Editora> list() {
		return editoraService.list();
	}

	@PostMapping("/create")
	public Editora create(@RequestBody Editora editora) {
		return editoraService.create(editora);
	}

	@PutMapping("/update/{id}")
	public Editora update(@PathVariable Integer id, @RequestBody Editora editora) {
		
		return editoraService.update(id, editora);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		editoraService.delete(id);
	}
}
