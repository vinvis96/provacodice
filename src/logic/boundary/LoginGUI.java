package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.UserBean;
import logic.control.ControlLogin;
import logic.utils.WindowManagerGUI;

public class LoginGUI {

	public static void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public static void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}

	public static void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: Data not found. Retry!");

		alert.showAndWait();
	}

	public static VBox getLoginPageScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		VBox root = new VBox();

		Text title = new Text();
		
		UserBean usBean = new UserBean();

		ControlLogin ctrlLogin = new ControlLogin();
		
		title.setText("Benvenuto in Social Music!");

		TextField usernameField = new TextField();
		PasswordField passwordField = new PasswordField();

		Button loginBTN = new Button("Accedi");
		Button registerBTN = new Button("Registrati");
		Button recoverDataBTN = new Button("Recupera Dati");

		usernameField.setMaxWidth(200);
		usernameField.setAlignment(Pos.CENTER_LEFT);
		usernameField.setPromptText("Username");

		passwordField.setMaxWidth(200);
		passwordField.setAlignment(Pos.CENTER_LEFT);
		passwordField.setPromptText("Password");

		loginBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

					sendUsernameAlert();

				} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

					sendPasswordAlert();

				} else {
					
					usBean.setUsername(usernameField.getText());
					usBean.setPassword(passwordField.getText());

					int res = ctrlLogin.checkIfRegistered(usBean);
					
					if(res==-1) {
						
						sendDataNotFoundAlert();
						
					} else {
						
						win.loadHomePage();
					}

				}
			}
		
		});

		registerBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				usernameField.clear();
				passwordField.clear();

				win.loadRegisterPage();
			}
		});

		recoverDataBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				usernameField.clear();
				passwordField.clear();

				win.loadRecoverDataPage();
			}
		});

		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, usernameField, passwordField, loginBTN, registerBTN, recoverDataBTN);

		return root;

	}
}
