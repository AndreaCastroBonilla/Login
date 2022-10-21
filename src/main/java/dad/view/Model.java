package dad.view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private BooleanProperty useLDAP = new SimpleBooleanProperty();

	public final StringProperty usuarioProperty() {
		return this.usuario;
	}

	public final String getUsuario() {
		return this.usuarioProperty().get();
	}

	public final void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}

	public final StringProperty passwordProperty() {
		return this.password;
	}

	public final String getPassword() {
		return this.passwordProperty().get();
	}

	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}

	public final BooleanProperty useLDAPProperty() {
		return this.useLDAP;
	}

	public final boolean isUseLDAP() {
		return this.useLDAPProperty().get();
	}

	public final void setUseLDAP(final boolean useLDAP) {
		this.useLDAPProperty().set(useLDAP);
	}

}
