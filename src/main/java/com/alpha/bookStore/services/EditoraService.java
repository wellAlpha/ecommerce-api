package com.alpha.bookStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.bookStore.entities.Editora;
import com.alpha.bookStore.repositories.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	EditoraRepository editoraRepository;

	public List<Editora> list() {
		return editoraRepository.findAll();
	}

	public Editora create(Editora editora) {
		return editoraRepository.save(editora);
	}

	public Editora update(Integer id, Editora editora) {
		var oldEditora = editoraRepository.findById(id).get();
		
		oldEditora.setDescricao(editora.getDescricao());
		
		return editoraRepository.save(oldEditora);
	}
	
	public void delete(Integer id) {
		var editora = editoraRepository.findById(id).get();

		editora.setAtivo(false);
		
		editoraRepository.save(editora);
	}
}
