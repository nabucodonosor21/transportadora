package br.com.transportadora.controllers;


import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import br.com.transportadora.App;
import br.com.transportadora.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable{

	public static BorderPane ROOT_LAYOUT;
	
	@FXML
	private TextField usuario;
	
	@FXML
	private PasswordField senha;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void entrar(final ActionEvent arg0){
		if(usuario.getText().equals("murilo") && senha.getText().equals("123")){
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("view/telaPrincipal.fxml"));
			try {
				
				ROOT_LAYOUT = (BorderPane) loader.load();
				App.PRIMARY_STAGE.close();

				Util.redireciona("view/contentPrincipal.fxml");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			Alert dialogoErro = new Alert(Alert.AlertType.WARNING);
			dialogoErro.setTitle("Erro");
			dialogoErro.setHeaderText("Autenticação inválida");
			dialogoErro.setContentText("Usuário ou senha inválido");
			dialogoErro.showAndWait();
		}
	}
	
}
