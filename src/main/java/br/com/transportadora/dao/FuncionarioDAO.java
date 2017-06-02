package br.com.transportadora.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FuncionarioDAO {

	Connection conexao;

	public FuncionarioDAO(Connection conn) {
		conexao = conn;
	}

	public String excluir(String nome) {
		try {

			String proc = "{adicionar_teste (?,?,?)}";
			CallableStatement call = conexao.prepareCall(proc);
			call.setString(1, nome);
			call.registerOutParameter(3, java.sql.Types.VARCHAR);
			call.registerOutParameter(2, java.sql.Types.VARCHAR);

			return call.getString("2");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
