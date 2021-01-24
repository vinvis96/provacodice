package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.UserBean;
import logic.control.ControlRecoverData;
import logic.utils.WindowManagerGUI;

public class RecoverDataGUI {
	
	public static void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public static void sendEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}

	public static void mailSentAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data");
		alert.setContentText("Success! Your Data has been sent at your email!");

		alert.showAndWait();
	}

	public static void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: Email not found. Retry!");

		alert.showAndWait();
	}

	public static VBox getRecoverDataPageScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		VBox root = new VBox();
		
		UserBean usBean = new UserBean();
		
		Text title = new Text();
		TextField usernameField = new TextField();
		TextField emailField = new TextField();
		Button recoverDataBTN = new Button("Recupera Dati");
		Button backBTN = new Button("Back");

		ControlRecoverData ctrlRecoverData = new ControlRecoverData();

		title.setText("Recover Data: Insert your Username & your Email below");
		
		usernameField.setMaxWidth(350);
		usernameField.setAlignment(Pos.CENTER_LEFT);
		usernameField.setPromptText("Username");

		emailField.setMaxWidth(350);
		emailField.setAlignment(Pos.CENTER_LEFT);
		emailField.setPromptText("Email");

		recoverDataBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

					sendUsernameAlert();

				} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

					sendEmailAlert();

				} else {
					
					usBean.setUsername(usernameField.getText());
					usBean.setEmail(emailField.getText());

					int res = ctrlRecoverData.sendEmail(usBean);
					
					if(res == -1) {
						
						sendDataNotFoundAlert();
						
					} else {
						
						mailSentAlert();
					}
				
					win.loadLoginPage();
				}
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadLoginPage();
			}

		});

		root.getChildren().addAll(title, usernameField, emailField, recoverDataBTN, backBTN);
		root.setAlignment(Pos.CENTER);

		return root;
	}

}
