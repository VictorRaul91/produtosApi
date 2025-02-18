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

		while (result.next()) {
			var categoria = new Categoria();

			categoria.setId(UUID.fromString(result.getString("ID")));
			categoria.setNome(result.getString("NOME"));

			lista.add(categoria);
		}

		connection.close();
		return lista;
	}

	public boolean exists(UUID id) throws Exception {

		var connection = ConnectionFactory.getConnetion();
		var statement = connection.prepareStatement("SELECT count(id) AS QTDE FROM CATEGORIA WHERE ID = ?");

		statement.setObject(1, id);
		var result = statement.executeQuery();

		var qtde = 0;

		if (result.next()) {
			qtde = result.getInt("qtde");
		}
		connection.close();

		return qtde > 0;

	}

	public void Atualizar(Categoria categoria) throws Exception {

		var connection = ConnectionFactory.getConnetion();

		var query = "UPDATE CATEGORIA SET NOME = ? WHERE ID = ?";

		var statement = connection.prepareStatement(query);
		statement.setString(1, categoria.getNome());
		statement.setObject(2, (categoria.getId()));
		statement.executeUpdate();
	}

}
