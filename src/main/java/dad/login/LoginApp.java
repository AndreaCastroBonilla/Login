package dad.login;

import dad.view.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {

	public static Stage primaryStage;
	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {

		LoginApp.primaryStage = primaryStage;
		controller = new Controller();

		primaryStage.setTitle("Login");
		primaryStage.setScene(new Scene(controller.getView(), 320, 200));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
