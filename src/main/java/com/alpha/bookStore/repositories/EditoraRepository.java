package com.alpha.bookStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.bookStore.entities.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {

	List<Editora> findByAtivoTrue();

}
