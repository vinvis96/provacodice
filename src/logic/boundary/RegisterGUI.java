package logic.boundary;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.UserBean;
import logic.control.ControlRegister;
import logic.utils.WindowManagerGUI;

public class RegisterGUI {
	
	public static void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public static void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}

	public static void sendEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}
	
	public static void sendBirthDateAlert() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert BirthDate. Retry!");

		alert.showAndWait();		
	}

	public static void sendFirstNameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert First Name. Retry!");

		alert.showAndWait();
	}

	public static void sendInstrPlayedAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert the Instrument Played. Retry!");

		alert.showAndWait();
	}

	public static void sendNameBandAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Name of your Band. Retry!");

		alert.showAndWait();
	}

	public static void sendEmailNotValidAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Email format not valid. Retry!");

		alert.showAndWait();
	}

	public static void sendUsernameAlreadyTakenAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Username already in use. Retry!");

		alert.showAndWait();
	}

	public static void sendEmailAlreadyTakenAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Email already in use. Retry!");

		alert.showAndWait();
	}

	public static void registrationAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration");
		alert.setContentText("Success! Your Account has been registrated!");

		alert.showAndWait();
	}
	
	public static void registrationErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration");
		alert.setContentText("Error: Something went wrong. Retry!");

		alert.showAndWait();
	}

	public static VBox getRegisterPageScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		UserBean usBean = new UserBean();

		VBox root = new VBox();

		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		HBox hb5 = new HBox();
		HBox hb6 = new HBox();

		Button registerBTN = new Button("Registrati");
		Button backBTN = new Button("Back");
		Text title = new Text();
		title.setText("Registrazione:");

		TextField usernameField = new TextField();
		PasswordField passwordField = new PasswordField();
		TextField emailField = new TextField();
		TextField firstNameField = new TextField();
		TextField lastNameField = new TextField();
		DatePicker birthDateField = new DatePicker();
		TextField zoneField = new TextField();
		TextField instrPlayedField = new TextField();
		CheckBox bandField = new CheckBox();
		TextField nameBandField = new TextField();

		ControlRegister ctrlRegister = new ControlRegister();

		usernameField.setMaxWidth(200);
		usernameField.setAlignment(Pos.CENTER_LEFT);
		usernameField.setPromptText("Username");

		passwordField.setMaxWidth(200);
		passwordField.setAlignment(Pos.CENTER_LEFT);
		passwordField.setPromptText("Password");

		emailField.setMaxWidth(350);
		emailField.setAlignment(Pos.CENTER_LEFT);
		emailField.setPromptText("Email");

		firstNameField.setMaxWidth(200);
		firstNameField.setAlignment(Pos.CENTER_LEFT);
		firstNameField.setPromptText("First Name");

		lastNameField.setMaxWidth(200);
		lastNameField.setAlignment(Pos.CENTER_LEFT);
		lastNameField.setPromptText("Last Name");

		birthDateField.setEditable(false);

		zoneField.setMaxWidth(200);
		zoneField.setAlignment(Pos.CENTER_LEFT);
		zoneField.setPromptText("Zone");

		instrPlayedField.setMaxWidth(200);
		instrPlayedField.setAlignment(Pos.CENTER_LEFT);
		instrPlayedField.setPromptText("Instrument");

		nameBandField.setMaxWidth(200);
		nameBandField.setAlignment(Pos.CENTER_LEFT);
		nameBandField.setPromptText("Name Band");
		nameBandField.setVisible(false);

		Text birth = new Text();
		birth.setText("When were you born?  ");

		Text band = new Text();
		band.setText("Are you in a band?");

		bandField.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				nameBandField.setVisible(newValue);
			}
		});

		registerBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

					sendUsernameAlert();

				} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

					sendPasswordAlert();

				} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

					sendEmailAlert();
					
				} else if (birthDateField.getValue() == null || birthDateField.getValue().toString().trim().isEmpty()) {

					sendBirthDateAlert();

				} else if (firstNameField.getText() == null || firstNameField.getText().trim().isEmpty()) {

					sendFirstNameAlert();

				} else if (instrPlayedField.getText() == null || instrPlayedField.getText().trim().isEmpty()) {

					sendInstrPlayedAlert();

				} else if (bandField.isSelected() && nameBandField.getText().equals("")) {

					sendNameBandAlert();

				} else if (!ctrlRegister.checkIfEmailIsValid(emailField.getText())) {

					sendEmailNotValidAlert();
					emailField.clear();

				} else {

					int bandFlag = -1;

					if (bandField.isSelected() && !nameBandField.getText().equals("")) {

						bandFlag = 1;

					} else {

						bandFlag = 0;

					}
					
					String result = ctrlRegister.checkUsernameAlreadyTaken(usernameField.getText());

					if (result.equals("trovato")) {

						sendUsernameAlreadyTakenAlert();
						usernameField.clear();

					} else {
						
						usBean.setUsername(usernameField.getText());
						usBean.setPassword(passwordField.getText());
						usBean.setEmail(emailField.getText());
						usBean.setFirstname(firstNameField.getText());
						
						if(lastNameField.getLength()>0) {
							
							usBean.setLastname(lastNameField.getText());
						} else {
							
							usBean.setLastname(null);
						}
						
						usBean.setBirthDate(birthDateField.getValue().toString());
						
						if(zoneField.getLength()>0) {
							
							usBean.setZone(zoneField.getText());
							
						} else {
							
							usBean.setZone(null);
						}
						
						usBean.setInstrPlayed(instrPlayedField.getText());
						usBean.setBand(bandFlag);
						if (bandFlag == 1) {
							usBean.setNameBand(nameBandField.getText());
						} else if (bandFlag == 0) {
							usBean.setNameBand(null);
						}

						int reg = ctrlRegister.registerUser(usBean);
						
						if(reg == -1) {
							
							registrationErrorAlert();
							win.loadLoginPage();
						} else {
							
							registrationAlert();
						}

						usernameField.clear();
						passwordField.clear();
						emailField.clear();
						firstNameField.clear();
						lastNameField.clear();
						birthDateField.setValue(null);
						zoneField.clear();
						instrPlayedField.clear();
						bandField.setSelected(false);
						nameBandField.clear();
						
						win.loadLoginPage();
						
					}

				}
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadLoginPage();
			}

		});

		hb1.getChildren().addAll(usernameField, passwordField);
		hb2.getChildren().addAll(emailField);
		hb3.getChildren().addAll(firstNameField, lastNameField);
		hb4.getChildren().addAll(zoneField, instrPlayedField);
		hb5.getChildren().addAll(band, bandField, nameBandField);
		hb6.getChildren().addAll(birth, birthDateField);

		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		hb3.setAlignment(Pos.CENTER);
		hb4.setAlignment(Pos.CENTER);
		hb5.setAlignment(Pos.CENTER);
		hb6.setAlignment(Pos.CENTER);

		root.getChildren().addAll(title, hb1, hb2, hb3, hb4, hb5, hb6, registerBTN, backBTN);
		root.setAlignment(Pos.CENTER);

		return root;

	}
}
