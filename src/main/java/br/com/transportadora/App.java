package br.com.transportadora;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

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

		URL resource = App.class.getResource("/sofia/fxml/Login.fxml");
		LOADER.setLocation(resource);
//			MainController.ROOT_LAYOUT = (BorderPane) LOADER.load();
//			Scene scene = new Scene(MainController.ROOT_LAYOUT, 300, altura);
//
//			primaryStage.setScene(scene);
//			primaryStage.setResizable(false);
//			primaryStage.show();
//
//			scene.getWindow().setOnCloseRequest(getCloseWindowEvent());
	}

	public static void main(final String[] args) {
		launch(args);
	}
}
