package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.CategoriaResponseDto;
import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/api/categorias")

public class CategoriasController {
	
	private ModelMapper mapper = new ModelMapper();
	
	@Operation(summary = "Serviço para consultar todas as categorias cadastradas no sistema.")
	@GetMapping("consultar")
	public List<CategoriaResponseDto> consultar(){
		try {
			
			var categoriaRepository = new CategoriaRepository();
			var categorias = categoriaRepository.select();
			
			var response = new ArrayList<CategoriaResponseDto>();
			
			for(var categoria : categorias) {
				response.add(mapper.map(categoria, CategoriaResponseDto.class));
			}
			
			return response;
			
			
			   
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Operation(summary = "Serviço para atualizar todas as categorias cadastradas no sistema.")
	@PutMapping("atualizar")
	public ResponseEntity<String> atualizar(@RequestBody Categoria categoria) {
	
		var categoriaRepository = new CategoriaRepository();
		
		try {
			
			categoriaRepository.Atualizar(categoria);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
