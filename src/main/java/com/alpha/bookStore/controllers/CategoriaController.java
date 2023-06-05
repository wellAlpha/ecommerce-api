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

import com.alpha.bookStore.entities.Categoria;
import com.alpha.bookStore.services.CategoriaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookstore/admin/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/list")
	public List<Categoria> list() {
		return categoriaService.list();
	}
	
	@PostMapping("/create")
	public Categoria create(@RequestBody Categoria body) {
		return categoriaService.create(body);
	}
	
	@PutMapping("/update/{id}")
	public Categoria update(@PathVariable Integer id, @RequestBody Categoria body)
	{
		return categoriaService.update(id, body);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id)
	{
		categoriaService.delete(id);
	}
}
