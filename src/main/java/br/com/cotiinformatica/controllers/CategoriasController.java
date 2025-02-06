package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/categorias")

public class CategoriasController {
	
	@Operation(summary = "Serviço para consultar todas as categorias cadastradas no sistema.")
	@GetMapping("consultar")
	public List<Categoria> consultar(){
		try {
			
			var categoriaRepository = new CategoriaRepository();
			return categoriaRepository.select();
			
			   
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
