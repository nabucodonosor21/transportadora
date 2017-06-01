package br.com.transportadora;

import java.io.IOException;
import java.net.URL;

import br.com.transportadora.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

	public static Stage PRIMARY_STAGE;
	public static FXMLLoader LOADER = new FXMLLoader();

	@Override
	public void start(final Stage primaryStage) {
		PRIMARY_STAGE = primaryStage;
		PRIMARY_STAGE.setTitle("Transportadora");
		iniciaLogin(PRIMARY_STAGE);
	}

	public void iniciaLogin(final Stage primaryStage) {

		try {
			URL resource = App.class.getResource("view/telaLogin.fxml");
			LOADER.setLocation(resource);
			LoginController.ROOT_LAYOUT = (BorderPane) LOADER.load();
			Scene scene = new Scene(LoginController.ROOT_LAYOUT);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

			// scene.getWindow().setOnCloseRequest(getCloseWindowEvent());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		launch(args);
	}
}
