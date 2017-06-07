package br.com.transportadora.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import br.com.transportadora.conf.ConexaoBD;
import br.com.transportadora.dao.FuncionarioDAO;
import br.com.transportadora.dto.FuncionarioDTO;
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
	private TextField txt_uf;

	@FXML
	private TextField txt_cidade;

	private FuncionarioDAO dao;
	
	private FuncionarioDTO funDTO;

	private Connection conn;

	public void initialize(URL location, ResourceBundle resources) {
		conn = new ConexaoBD().connect();
		dao = new FuncionarioDAO(conn);
	}

	public void actionLimpar(final ActionEvent arg0) {
		Util.redirecionaChild("view/contentCliente.fxml");
	}

	public void actionConsultar(final ActionEvent arg0) {
		funDTO = dao.consultar("555");
		populaTabelaFunc(funDTO);
	}

	private void populaTabelaFunc(FuncionarioDTO funDTO2) {
		txt_cpf.setText(funDTO2.getTxt_cpf());
		
	}

	@FXML
	public void actionSalvar(final ActionEvent arg0) {
		 String salvar = dao.salvar(txt_cpf.getText(), txt_nome.getText(),
		 txt_sobrenome.getText(), txt_data_nasc.getText(), txt_ddd.getText(),
		 txt_telefone.getText(), txt_email.getText(),
		 txt_uf.getText(), txt_cidade.getText(), txt_cep.getText(),
		 txt_logradouro.getText(), txt_num.getText(), txt_bairro.getText(),
		 txt_complemento.getText());

		 Util.imprimeMsg(salvar);
	}

	public void actionExcluir(final ActionEvent arg0) {
		String excluir = dao.excluir(txt_cpf.getText());

		Util.imprimeMsg(excluir);
	}

	public void actionAtualizar(final ActionEvent arg0) {
		 String atualizar = dao.atualizar(txt_cpf.getText(), txt_nome.getText(),
		 txt_sobrenome.getText(), txt_data_nasc.getText(), txt_ddd.getText(),
		 txt_telefone.getText(), txt_email.getText(),
		 txt_uf.getText(), txt_cidade.getText(), txt_cep.getText(),
		 txt_logradouro.getText(), txt_num.getText(), txt_bairro.getText(),
		 txt_complemento.getText());

		 Util.imprimeMsg(atualizar);
	}

	public void actionVoltar(final ActionEvent arg0) {
		Util.redirecionaChild("view/contentPrincipal.fxml");
	}

}
