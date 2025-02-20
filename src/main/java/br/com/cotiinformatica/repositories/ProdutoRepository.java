package br.com.cotiinformatica.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ProdutoRepository {

	public List<Produto> findAll(String nome) throws Exception {

		var connection = ConnectionFactory.getConnetion();

		var query = "SELECT * FROM PRODUTO WHERE UPPER(NOME) LIKE UPPER(?)";
		var statement = connection.prepareStatement(query);
		statement.setString(1, "%" + nome + "%");
		var resultado = statement.executeQuery();

		var lista = new ArrayList<Produto>();

		while (resultado.next()) {

			var produto = new Produto();
			produto.setId(UUID.fromString(resultado.getString("ID")));
			produto.setNome(resultado.getString("NOME"));
			produto.setQuantidade(resultado.getInt("QUANTIDADE"));
			produto.setPreco(resultado.getDouble("PRECO"));
			lista.add(produto);
		}

		connection.close();
		return lista;

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

	public void update(Produto produto, UUID categoriaId) throws Exception {

		var connection = ConnectionFactory.getConnetion();
		var query = "UPDATE PRODUTO SET NOME = ?,PRECO =?,QUANTIDADE=?,CATEGORIA_ID=? WHERE ID = ?";

		var statement = connection.prepareStatement(query);
		statement.setString(1, produto.getNome());
		statement.setDouble(2, produto.getPreco());
		statement.setInt(3, produto.getQuantidade());
		statement.setObject(4, categoriaId);
		statement.setObject(5, produto.getId());
		statement.executeUpdate();

		connection.close();
	}

	public void delete(UUID produtoId) throws Exception {

		var connection = ConnectionFactory.getConnetion();
		var query = "DELETE FROM PRODUTO WHERE ID = ?";

		var statement = connection.prepareStatement(query);
		statement.setObject(1, produtoId);
		statement.executeUpdate();

		connection.close();

	}
	
	public Boolean exists(UUID produtoId) throws Exception{
		
		var connection = ConnectionFactory.getConnetion();
		var query = "SELECT COUNT(*) as qtde FROM PRODUTO WHERE ID = ?";
		
		var statement = connection.prepareStatement(query);
		statement.setObject(1, produtoId);
		var result = statement.executeQuery();
		
		var qtde = 0;

		if (result.next()) {
			qtde = result.getInt("qtde");
		}
		connection.close();

		return qtde > 0;
	}

}
