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



	public FuncionarioDTO consultarCpf(String cpf) {

		try {
			statement = conexao.createStatement();

			String sql = "SELECT * FROM funcionario where cpf like '"+cpf+"';";
			ResultSet rs = statement.executeQuery(sql);
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				
				funDTO = new FuncionarioDTO();
				funDTO.setTxt_cep(rs.getString("cpf"));
				
				/*preencher com os demais*/

			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funDTO;

	}
	
	public String salvar (FuncionarioDTO funDTO) {
		try {
			String proc = "{CALL adicionar_funcionario (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement call = conexao.prepareCall(proc);
			call.setString("p_uf", funDTO.getTxt_uf());
			call.setString("p_cidade", funDTO.getTxt_cidade());
			call.setString("p_cep", funDTO.getTxt_cep());
			call.setString("p_logradouro", funDTO.getTxt_logradouro());
			call.setString("p_num", funDTO.getTxt_num());
			call.setString("p_bairro", funDTO.getTxt_bairro());
			call.setString("p_complemento", funDTO.getTxt_complemento());			
			call.setString("p_nome_fun", funDTO.getTxt_nome());
			call.setString("p_sobrenome", funDTO.getTxt_sobrenome());
			call.setString("p_cpf", funDTO.getTxt_cpf());
			call.setString("p_data_nasc", funDTO.getTxt_data_nasc());
			call.setString("p_ddd", funDTO.getTxt_ddd());
			call.setString("p_telefone", funDTO.getTxt_telefone());
			call.setString("p_cargo",funDTO.getTxt_email());	
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
