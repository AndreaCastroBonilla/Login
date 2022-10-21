package dad.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View extends GridPane {

	private TextField userText;
	private PasswordField passwordText;
	private CheckBox ldapButton;
	private Button accederButton, cancelarButton;

	public View() {
		super();

		userText = new TextField();
		userText.setPromptText("Nombre de usuario");

		passwordText = new PasswordField();
		passwordText.setPromptText("Contraseña");

		ldapButton = new CheckBox("usar LDAP");

		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		cancelarButton = new Button("Cancelar");

		HBox botones = new HBox(accederButton, cancelarButton);
		botones.setAlignment(Pos.CENTER);
		botones.setSpacing(5);

		setHgap(5);
		setVgap(5);
		setAlignment(Pos.CENTER);
//		setGridLinesVisible(true);

		addRow(0, new Label("Usuario: "), userText);
		addRow(1, new Label("Contraseña: "), passwordText);
		addRow(2, new Label(""), ldapButton);
		addRow(3, botones);

		GridPane.setColumnSpan(botones, 2);
	}

	public TextField getUserText() {
		return userText;
	}

	public PasswordField getPasswordText() {
		return passwordText;
	}

	public CheckBox getLdapButton() {
		return ldapButton;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

}
