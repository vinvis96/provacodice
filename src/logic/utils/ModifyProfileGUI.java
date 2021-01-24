package logic.utils;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.UserBean;
import logic.control.ControlProfile;

public class ModifyProfileGUI {
	
public static VBox getModifyProfileScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		ControlProfile ctrlProfile = new ControlProfile();

		VBox root = new VBox();
		HBox hbox = new HBox();
		
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		HBox hb5 = new HBox();
		HBox hb6 = new HBox();
		
		
		Text title = new Text();
		title.setText("Modify Profile Page\nIf field is empty, it will be saved last value");
		
		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button okBTN = new Button("Submit");
		Button backBTN = new Button("Back");
		
		Text firstname = new Text();
		TextField newFirstnameField = new TextField();
		
		Text lastname = new Text();
		TextField newLastnameField = new TextField();
				
		Text birthdate = new Text();
		DatePicker newBirthDateField = new DatePicker();
		
		Text zone = new Text();
		TextField newZoneField = new TextField();
		
		Text instr = new Text();
		TextField newInstrField = new TextField();
		
		Text band = new Text();
		CheckBox bandField = new CheckBox();
		
		Text nameBand = new Text();
		TextField newNameBandField = new TextField();
		nameBand.setVisible(false);
		
		newFirstnameField.setMaxWidth(200);
		newFirstnameField.setPromptText("New Firstname");
		newLastnameField.setMaxWidth(200);
		newLastnameField.setPromptText("New Lastname");
		newZoneField.setMaxWidth(200);
		newZoneField.setPromptText("New Zone");
		newInstrField.setMaxWidth(200);
		newInstrField.setPromptText("New Instrument Played");
		newNameBandField.setMaxWidth(200);
		newNameBandField.setPromptText("New Band Name");
		newNameBandField.setVisible(false);
		newBirthDateField.setEditable(false);
		newBirthDateField.setPromptText("New Birth Date");
		
		UserBean user = ctrlProfile.getCurrentUserData();
				
		firstname.setText("Insert new Firstname (old was: " + user.getFirstname() + ")" );
		lastname.setText("Insert new Lastname (old was: " + user.getLastname() + ")");
		zone.setText("Insert new Zone (old was: " + user.getZone() + ")");
		instr.setText("Insert new Instrument Played (old was: " + user.getInstrPlayed() + ")");
		
		birthdate.setText("Insert new Birth Date (old was: " + user.getBirthDate() + ")" );
			
		band.setText("Are you in a band now? (Y/N)");
		
		bandField.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				
				nameBand.setVisible(newValue);
				newNameBandField.setVisible(newValue);
				
				if(user.getBand() == 0) {
					
					nameBand.setText("Insert new Band Name");					
					
				} else {
					
					nameBand.setText("Insert new Band Name (old was: " + user.getNameBand() + ")");
				}
			}
		});
		
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
		
		okBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				if(!newFirstnameField.getText().trim().isEmpty()) {
					user.setFirstname(newFirstnameField.getText());
				}
				if(!newLastnameField.getText().trim().isEmpty()) {
					user.setLastname(newLastnameField.getText());
				}
				if(newBirthDateField.getValue() != null) {
					user.setBirthDate(newBirthDateField.getValue().toString());
				}
				if(!newZoneField.getText().trim().isEmpty()) {
					user.setZone(newZoneField.getText());
				}
				if(!newInstrField.getText().trim().isEmpty()) {
					user.setInstrPlayed(newInstrField.getText());
				}
				if(bandField.isSelected()) {
					user.setBand(1);
					if(!newNameBandField.getText().trim().isEmpty()) {
						user.setNameBand(newNameBandField.getText());
					}
				} else {
					user.setBand(0);
					user.setNameBand("null");
				}
				
				ctrlProfile.modifyCurrentUserProfile(user);
				win.loadProfilePage();
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadProfilePage();
			}
		});
		
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		hb3.setAlignment(Pos.CENTER);
		hb4.setAlignment(Pos.CENTER);
		hb5.setAlignment(Pos.CENTER);
		hb6.setAlignment(Pos.CENTER);
		
		hb1.getChildren().addAll(firstname, newFirstnameField);
		hb2.getChildren().addAll(lastname,newLastnameField);
		hb3.getChildren().addAll(birthdate, newBirthDateField);
		hb4.getChildren().addAll(zone, newZoneField);
		hb5.getChildren().addAll(instr, newInstrField);
		hb6.getChildren().addAll(nameBand, newNameBandField);
		
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, hbox, hb1, hb2, hb3, hb4, hb5, band, bandField, hb6, okBTN, backBTN);
		
		return root;
		
	}

}
