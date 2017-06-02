package br.com.transportadora.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.transportadora.conf.ConexaoBD;
import br.com.transportadora.dao.FuncionarioDAO;
import br.com.transportadora.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class FuncionarioController implements Initializable {

	@FXML
	private TextField txt_telefone;
	
	@FXML
	private TextField txt_data_nasc;
	
	@FXML
	private TextField txt_complemento;
	
	@FXML
	private TextField txt_cep;
	
	@FXML
	private TextField txt_nome;
	
	@FXML
	private TextField txt_email;
	
	@FXML
	private TextField txt_bairro;
	
	@FXML
	private TextField txt_cpf;
	
	@FXML
	private TextField txt_logradouro;
	
	@FXML
	private TextField txt_ddd;
	
	@FXML
	private TextField txt_sobrenome;
	
	@FXML
	private TextField txt_num;
	
	@FXML
	private ChoiceBox<String> combo_uf;
	
	@FXML
	private ChoiceBox<String> combo_cidade;

	private FuncionarioDAO dao;	
	
	private Connection conn;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conn = new ConexaoBD().connect();
		dao = new FuncionarioDAO(conn);
		
	}
	
	public void actionLimpar(final ActionEvent arg0){
		Util.redirecionaChild("view/contentCliente.fxml");		
	}
	
	public void actionConsultar(final ActionEvent arg0){
		
	}	

	public void actionSalvar(final ActionEvent arg0){
		
	}	
	
	public void actionExcluir(final ActionEvent arg0){
		String excluir = dao.excluir(txt_nome.getText());
		
		Util.imprimeMsg(excluir);

	}
	
	public void actionAtualizar(final ActionEvent arg0){
		
	}

	public void actionVoltar(final ActionEvent arg0){
		Util.redirecionaChild("view/contentPrincipal.fxml");
	}		
	
}
