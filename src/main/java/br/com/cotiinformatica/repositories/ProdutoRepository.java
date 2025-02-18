package br.com.cotiinformatica.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ProdutoRepository {
	
	public List<Produto> select() throws Exception{
		
		var connection = ConnectionFactory.getConnetion();
		
		var query = "SELECT * FROM PRODUTO";
		var statement = connection.prepareStatement(query);
		var resultado = statement.executeQuery();
		
		var produto = new Produto();
		var Lista = new ArrayList<Produto>();
		
		while (resultado.next()) {
			
			produto.setId(UUID.fromString(resultado.getString("ID")));
			produto.setNome(resultado.getString("NOME"));
			produto.setQuantidade(resultado.getInt("QUANTIDADE"));
			produto.setPreco(resultado.getDouble("PRECO"));
			//produto.getCategoria().setId(resultado.getObject("ID"));
			//todo
			
		}
		
		return null; //todo
		
	}

	
	public void inserir(Produto produto, UUID categoriaId) throws Exception {
		
		var connection = ConnectionFactory.getConnetion();
		
		var query = "INSERT INTO PRODUTO(ID,NOME,PRECO,QUANTIDADE,CATEGORIA_ID) VALUES (?,?,?,?,?)";
		var statement = connection.prepareStatement(query);
		statement.setObject(1, produto.getId());
		statement.setString(2, produto.getNome());
		statement.setDouble(3, produto.getPreco());
		statement.setInt(4, produto.getQuantidade());
		statement.setObject(5, categoriaId);
		statement.executeUpdate();
		
		connection.close();
	}
	
	
	
}
