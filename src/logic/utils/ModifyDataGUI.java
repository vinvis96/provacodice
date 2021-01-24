package logic.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.bean.UserBean;
import logic.control.ControlProfile;

public class ModifyDataGUI {

	public static VBox getModifyDataScene() {


		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		ControlProfile ctrlProfile = new ControlProfile();

		VBox root = new VBox();
		HBox hbox = new HBox();
		
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		
		Text title = new Text();
		title.setText("Modify data Page\n\nIf field is empty, it will be saved last value");
		title.setTextAlignment(TextAlignment.CENTER);
		
		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button okBTN = new Button("Submit");
		Button backBTN = new Button("Back");
		
		Text password = new Text();
		TextField newPasswordField = new TextField();
		Text email = new Text();
		TextField newEmailField = new TextField();
		
		newPasswordField.setMaxWidth(200);
		newPasswordField.setPromptText("New Password");
		newEmailField.setMaxWidth(200);
		newEmailField.setPromptText("New Email");
		
		UserBean user = ctrlProfile.getCurrentUserData();
		
		password.setText("Insert new Firstname (old was: " + user.getPassword() + ")" );
		email.setText("Insert new Lastname (old was: " + user.getEmail() + ")");
		
		homeBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadHomePage();
			}
		});

		messagesBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadMessagesPage();
			}
		});

		profileBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadProfilePage();
			}
		});

		logoutBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadLoginPage();
			}
		});
		
		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadProfilePage();
			}
		});
		
		okBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				if(!newPasswordField.getText().trim().isEmpty()) {
					user.setPassword(newPasswordField.getText());
				}
				if(!newEmailField.getText().trim().isEmpty()) {
					user.setEmail(newEmailField.getText());
				}
				
				if (!ctrlProfile.checkIfEmailIsValid(newEmailField.getText())) {

					ctrlProfile.sendEmailNotValidAlert();

				} else {
				
					ctrlProfile.modifyCurrentUserProfile(user);
					win.loadProfilePage();
				}
				
				newPasswordField.clear();
				newEmailField.clear();
				
			}
		});
		
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		
		hb1.getChildren().addAll(password, newPasswordField);
		hb2.getChildren().addAll(email,newEmailField);
		
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, hbox, hb1, hb2, okBTN, backBTN);
		
		return root;
	}

}
