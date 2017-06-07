package br.com.transportadora.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.transportadora.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class MenuController implements Initializable{
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionFuncionario(final ActionEvent arg0){
		Util.redirecionaChild("view/contentFuncionario.fxml");
	}
	
	public void actionCliente(final ActionEvent arg0){
		Util.redirecionaChild("view/contentCliente.fxml");
	}
	
	public void actionVeiculo(final ActionEvent arg0){
		
	}
	
	public void actionServico(final ActionEvent arg0){
		
	}
	
	public void actionSair(final ActionEvent arg0){
		System.exit(0);
	}

}
