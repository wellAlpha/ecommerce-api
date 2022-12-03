package com.alpha.bookStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.bookStore.entities.Autor;
import com.alpha.bookStore.repositories.AutorRepository;
@Service
public class AutorService {
	@Autowired
	AutorRepository autorRepository;
	
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}

	public Autor create(Autor autor) {
		return autorRepository.save(autor);
	}

	public Autor update(Integer id, Autor autor) {
		var oldAutor = autorRepository.findById(id).get();
		
		oldAutor.setNome(autor.getNome());
		
		return autorRepository.save(oldAutor);
	}
	
	public void delete(Integer id) {
		var autor = autorRepository.findById(id).get();

		autor.setAtivo(false);
		
		autorRepository.save(autor);
	}
}
