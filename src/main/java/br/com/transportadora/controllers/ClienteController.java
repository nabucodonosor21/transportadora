package br.com.transportadora.controllers;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import br.com.transportadora.App;
import br.com.transportadora.conf.ConexaoBD;
import br.com.transportadora.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ClienteController implements Initializable{
	
	public static BorderPane ROOT_LAYOUT;
			
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void actionLimpar(final ActionEvent arg0){
		Util.redirecionaChild("view/contentCliente.fxml");
	}
	
	public void actionConsultar(final ActionEvent arg0){
		
	}	

	public void actionSalvar(final ActionEvent arg0){
		
	}	
	
	public void actionExcluir(final ActionEvent arg0){

	}
	
	public void actionAtualizar(final ActionEvent arg0){
		
	}

	public void actionVoltar(final ActionEvent arg0){
		Util.redirecionaChild("view/contentPrincipal.fxml");
	}	
}
