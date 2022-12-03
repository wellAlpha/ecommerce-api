package com.alpha.bookStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.bookStore.entities.Livro;
import com.alpha.bookStore.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> list (){
		return livroRepository.findAll();
	}
	
	public Livro create(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro update(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public void delete(Integer id) {
		var livro = livroRepository.findById(id).get();
		
		livro.setAtivo(false);
		livro.setDestaque(false);
		
		livroRepository.save(livro);
	}
}
