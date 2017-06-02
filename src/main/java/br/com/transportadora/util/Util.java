package br.com.transportadora.util;

import java.io.IOException;

import br.com.transportadora.App;
import br.com.transportadora.controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Util {

	public static void redireciona(String urlFxml) {
		redireciona(urlFxml, "Transportadora");
	}

	public static void redireciona(String urlFxml, String titulo) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource(urlFxml));

			AnchorPane ap = (AnchorPane) loader.load();
			LoginController.ROOT_LAYOUT.setCenter(ap);

			Stage stage = new Stage();
			stage.setScene(new Scene(LoginController.ROOT_LAYOUT));
			stage.setTitle(titulo);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static FXMLLoader redirecionaChild(String urlFxml) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource(urlFxml));
			Object obj = loader.load();

			LoginController.ROOT_LAYOUT.setCenter((Node) obj);
			return loader;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void imprimeMsg(String excluir) {
		// TODO Auto-generated method stub
		
	}

}
