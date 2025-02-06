package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.entities.Produto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/produtos")

public class ProdutosController {

	@Operation(summary = "Serviço para cadastro de produto.")
	@PostMapping("cadastrar")
	public void cadastrar() {

		// todo
	}
	
	@Operation(summary = "Servico para atualizar  produto.")
	@PutMapping("atualizar")
	public void atualizar() {
		
	}
	
	@Operation(summary = "Servico para excluir produto.")
	@DeleteMapping("excluir")
	public void excluir() {
		
	}
	
	@Operation(summary = "Servico para consulta de todos os produto.")
	@GetMapping("consultar")
	public void consultar() {
		
	}
}
