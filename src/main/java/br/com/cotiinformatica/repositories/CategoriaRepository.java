package br.com.cotiinformatica.repositories;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class CategoriaRepository {

public List<Categoria> select() throws Exception {
	
	var connection = ConnectionFactory.getConnetion();
		
	var query = "SELECT * FROM CATEGORIA";
	
	var statement = connection.prepareStatement(query);
	var result = statement.executeQuery();
	
	
	var lista = new ArrayList<Categoria>();
	
	while(result.next()) {
		var categoria = new Categoria();
		
		categoria.setId(UUID.fromString(result.getString("ID")));
		categoria.setNome(result.getString("NOME"));
		
		lista.add(categoria);
	}
	
		
		
	connection.close();
		return lista; 
	}
	
}
