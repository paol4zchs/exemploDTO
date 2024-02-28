package com.paola.EXEMPLODTO.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.paola.EXEMPLODTO.DTO.LivroDTO;
import com.paola.EXEMPLODTO.entity.Livro;
import com.paola.EXEMPLODTO.service.LivroService;

import jakarta.validation.Valid;

public class LivroController {

	private final LivroService livroService;
	
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}
	
	public ResponseEntity<LivroDTO> criar(@RequestBody Livro livro) {
		LivroDTO salvarLivro = livroService.salvar(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvarLivro);
		}
	
	public ResponseEntity<LivroDTO> alteraClienteControl(@PathVariable  Long id, @RequestBody @Valid Livro livro){
		LivroDTO alteraLivroDTO = livroService.atualizar(id, livro);
		if(alteraLivroDTO != null) {
			return ResponseEntity.ok(alteraLivroDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity <Livro> apagaClienteControl(@PathVariable Long id) {
		boolean apagar = livroService.deletar(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id){
		Livro livro = livroService.buscarPorId(id);
		if(livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		
		public ResponseEntity<List<Livro>> buscarTodosLivros(){
			List<Livro> Livro = livroService.buscarTodos();
			return ResponseEntity.ok(Livro);
		}
	}
