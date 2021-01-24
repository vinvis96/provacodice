package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.UserBean;
import logic.control.ControlProfile;
import logic.utils.WindowManagerGUI;

public class ProfileGUI {

	public static VBox getProfileScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		ControlProfile ctrlProfile = new ControlProfile();

		VBox root = new VBox();
		HBox hbox = new HBox();
		Text title = new Text();

		title.setText("My Profile");
		
		TextArea dataArea = new TextArea();
		
		dataArea.setEditable(false);

		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button modifyDataBTN = new Button("Modify Data");
		Button modifyProfileBTN = new Button("Modify Profile");
		Button backBTN = new Button("Back");
		
		UserBean user = ctrlProfile.getCurrentUserData();
		
		if(user.getBand() == 1) {
			
			dataArea.setText("YOUR PROFILE:\n\nUsername: " + user.getUsername() + "\nEmail: " + user.getEmail() 
			+ "\nFirst name: " + user.getFirstname() + "\nLast name: " + user.getLastname()
			+ "\nSubs Date: " + user.getSubsDate() + "\nBirth Date: " + user.getBirthDate() 
			+ "\nZone: " + user.getZone() + "\nInstrument Played: " + user.getInstrPlayed() 
			+ "\nIn a band: YES\nName Band: " + user.getNameBand());
			
		} else if(user.getBand() == 0) {
			
			dataArea.setText("YOUR PROFILE:\n\nUsername: " + user.getUsername() + "\nEmail: " + user.getEmail() 
			+ "\nFirst name: " + user.getFirstname() + "\nLast name: " + user.getLastname()
			+ "\nSubs Date: " + user.getSubsDate() + "\nBirth Date: " + user.getBirthDate() 
			+ "\nZone: " + user.getZone() + "\nInstrument Played: " + user.getInstrPlayed() 
			+ "\nIn a band: NO");
			
		}
		
		

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

				win.loadHomePage();
			}
		});
		
		modifyProfileBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				win.loadModifyProfilePage();

			}
		});

		modifyDataBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				win.loadModifyDataPage();

			}
		});

		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, hbox, dataArea, modifyProfileBTN, modifyDataBTN, backBTN);

		
		return root;
	}

}
