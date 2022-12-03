package com.alpha.bookStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.bookStore.entities.Categoria;
import com.alpha.bookStore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> list() {
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria body) {
		return categoriaRepository.save(body);
	}
	
	public Categoria update(Integer id, Categoria body)
	{
		var antigaCategoria = categoriaRepository.findById(id).get();
		antigaCategoria.setDescricao(body.getDescricao());
		categoriaRepository.save(antigaCategoria);
		return antigaCategoria;
		
		
	}
	
	public void delete(Integer id)
	{
		var categoria = categoriaRepository.findById(id).get();
		categoria.setAtivo(false);
		categoriaRepository.save(categoria);
	}
}
