package dad.view;

import dad.login.LoginApp;
import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	private View view = new View();
	private Model model = new Model();
	private Alert alert;
	boolean login;

	public Controller() {
		
		model.usuarioProperty().bind(view.getUserText().textProperty());
		model.passwordProperty().bind(view.getPasswordText().textProperty());

		view.getAccederButton().setOnAction(this::onAccederAction);
		view.getCancelarButton().setOnAction(this::onCancelarAction);

	}

	public View getView() {
		return view;
	}

	private void onCancelarAction(ActionEvent e) {
		LoginApp.primaryStage.close();
	}

	private void onAccederAction(ActionEvent e) {
		AuthService auth = model.isUseLDAP() ? new LdapAuthService() : new FileAuthService();

		try {

			if (auth.login(model.getUsuario(), model.getPassword())) {

				loginCorrecto();

			} else {

				loginIncorrecto();
			}

		} catch (Exception e1) {

			System.err.println("ERROR EN LA VALIDACIÓN DEL USUARIO");
			e1.printStackTrace();
		}
	}

	private void loginIncorrecto() {
		alert = new Alert(AlertType.ERROR);
		alert.setTitle("Iniciar Sesión");
		alert.setHeaderText("Acceso denegado");
		alert.setContentText("El usuario y/o contraseña no son válidos");
		alert.showAndWait();
	}

	private void loginCorrecto() {
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Iniciar Sesión");
		alert.setHeaderText("Acceso permitido");
		alert.setContentText("Las credenciales de acceso son válidas");
		alert.showAndWait();
	}

}
