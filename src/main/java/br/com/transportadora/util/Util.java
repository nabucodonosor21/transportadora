package br.com.transportadora.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import br.com.transportadora.App;
import br.com.transportadora.controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Util {

	public static Object redirecionaChildNew(String urlFxml) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource(urlFxml));
			Object obj = loader.load();

			// MainController.ROOT_LAYOUT.setCenter(resizeResponsive(obj));

			return obj;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object redirecionaChildOld(String urlFxml, Object loader) {

		// MainController.ROOT_LAYOUT.setCenter(resizeResponsive(loader));
		return loader;
	}
	
	public static void redireciona(String urlFxml) {
		redireciona(urlFxml, "Sofia");
	}

	public static void redireciona(String urlFxml, String titulo) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource(urlFxml));

			AnchorPane ap = (AnchorPane) loader.load();
			LoginController.ROOT_LAYOUT.setCenter(ap);
			Stage stage = new Stage();
//			setStage(stage);
			stage.setScene(new Scene(LoginController.ROOT_LAYOUT));
			stage.setTitle(titulo);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
