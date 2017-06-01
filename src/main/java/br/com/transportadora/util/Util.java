package br.com.transportadora.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import org.apache.log4j.Logger;

import br.com.transportadora.App;
import br.com.transportadora.controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
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

			FlowPane ap = (FlowPane) loader.load();
			LoginController.ROOT_LAYOUT.setCenter(ap);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			Stage stage = new Stage();
			// stage.initStyle(StageStyle.UNDECORATED);
//			setStage(stage);
			stage.setMinWidth(dim.width - (dim.width * 0.48));
			stage.setMinHeight(dim.height - (dim.height * 0.28));
			stage.setFullScreen(false);
			stage.setScene(new Scene(LoginController.ROOT_LAYOUT));
			stage.setTitle(titulo);
			stage.show();
		} catch (IOException e) {
			Logger.getLogger(Util.class).error("Erro ao carregar imagem de icone.",e);
		}catch (IllegalArgumentException e) {
			Logger.getLogger(Util.class).error("Erro no redirecionamento de telas.");
		}
	}

}
