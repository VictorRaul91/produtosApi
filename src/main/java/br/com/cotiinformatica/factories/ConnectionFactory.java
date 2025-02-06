package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnetion() throws Exception {
		
		var host = "jdbc:postgresql://localhost:5438/bd_produtosapi";
		var usuario = "admin";
		var senha ="senha123";
		
		return DriverManager.getConnection(host, usuario, senha );
		
	}
}
