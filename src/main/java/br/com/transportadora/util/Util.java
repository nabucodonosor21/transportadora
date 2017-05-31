package br.com.transportadora.util;

import java.io.IOException;

import br.com.transportadora.App;
import javafx.fxml.FXMLLoader;

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

}
