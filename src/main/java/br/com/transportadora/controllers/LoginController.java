package br.com.transportadora.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.transportadora.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable{

	public static BorderPane ROOT_LAYOUT;
	
	@FXML
	private TextField usuario;
	
	@FXML
	private TextField senha;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	public static void entrar() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(App.class.getResource("/sofia/fxml/principalView.fxml"));
		try {
			
			ROOT_LAYOUT = (BorderPane) loader.load();
			App.PRIMARY_STAGE.close();

//			Util.redireciona("/sofia/fxml/dashboardViewSinoreg.fxml");
	
			
		} catch (Exception e) {
			
		}
	}
}
