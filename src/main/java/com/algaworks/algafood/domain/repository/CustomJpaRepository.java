package com.algaworks.algafood.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaExeption;

@NoRepositoryBean
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {
	
	Optional<T> buscarPrimeiro();
	
	T buscarOuFalhar(ID id)
			throws EntidadeNaoEncontradaExeption;

}
