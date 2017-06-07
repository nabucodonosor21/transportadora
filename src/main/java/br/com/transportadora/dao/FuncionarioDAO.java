package br.com.transportadora.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.transportadora.dto.FuncionarioDTO;

public class FuncionarioDAO {

	Connection conexao;
	
	FuncionarioDTO funDTO;

	private Statement statement;

	public FuncionarioDAO(Connection conn) {
		conexao = conn;
	}

	public String excluir(String cpf) {
		try {

			String proc = "{CALL excluir_funcionario (?,?,?)}";
			CallableStatement call = conexao.prepareCall(proc);
			call.setString("p_cpf", cpf);
			call.registerOutParameter("p_erro_cod", java.sql.Types.VARCHAR);
			call.registerOutParameter("p_erro_msg", java.sql.Types.VARCHAR);
			
			call.execute();
			
			return call.getString("p_erro_msg");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



	public FuncionarioDTO consultar(String cpf) {

		try {
			statement = conexao.createStatement();

			String sql = "SELECT id, first, last, age FROM Registration";
			ResultSet rs = statement.executeQuery(sql);
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				funDTO.setTxt_cep(rs.getString("cpf"));

			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funDTO;

	}
	
	public String salvar (String cpf, String nome, String sobrenome, String data, String ddd, String telefone, String email, String uf, String cidade,
						  String cep, String logradouro, String num, String bairro, String complemento) {
		try {
			String proc = "{CALL adicionar_funcionario (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement call = conexao.prepareCall(proc);
			call.setString("p_uf", uf);
			call.setString("p_cidade", cidade);
			call.setString("p_cep", cep);
			call.setString("p_logradouro", logradouro);
			call.setString("p_num", num);
			call.setString("p_bairro", bairro);
			call.setString("p_complemento", complemento);			
			call.setString("p_nome_fun", nome);
			call.setString("p_sobrenome", sobrenome);
			call.setString("p_cpf", cpf);
			call.setString("p_data_nasc", data);
			call.setString("p_ddd", ddd);
			call.setString("p_telefone", telefone);
			call.setString("p_cargo", email);	
			call.registerOutParameter("p_erro_cod", java.sql.Types.VARCHAR);
			call.registerOutParameter("p_erro_msg", java.sql.Types.VARCHAR);
			
			call.execute();
			
			return call.getString("p_erro_msg");
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String atualizar (String cpf, String nome, String sobrenome, String data, String ddd, String telefone, String email, String uf, String cidade,
			  String cep, String logradouro, String num, String bairro, String complemento) {
		try {
			String proc = "{CALL atualizar_funcionario (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement call = conexao.prepareCall(proc);
			call.setString("p_uf", uf);
			call.setString("p_cidade", cidade);
			call.setString("p_cep", cep);
			call.setString("p_logradouro", logradouro);
			call.setString("p_num", num);
			call.setString("p_bairro", bairro);
			call.setString("p_complemento", complemento);			
			call.setString("p_nome_fun", nome);
			call.setString("p_sobrenome", sobrenome);
			call.setString("p_cpf", cpf);
			call.setString("p_data_nasc", data);
			call.setString("p_ddd", ddd);
			call.setString("p_telefone", telefone);
			call.setString("p_cargo", email);	
			call.registerOutParameter("p_erro_cod", java.sql.Types.VARCHAR);
			call.registerOutParameter("p_erro_msg", java.sql.Types.VARCHAR);
			
			call.execute();
			
			return call.getString("p_erro_msg");
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
