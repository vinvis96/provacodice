package logic.utils;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.PostBean;
import logic.control.ControlRequestPost;

public class ManageRequestPostGUI {
	
	static int cmd = -1;
	
	public static void modifyRequestPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Post Modify Successfully");
		alert.setContentText("Success! Your Post has been modified!");

		alert.showAndWait();
	}

	public static void modifyRequestPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Modify Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}
	
	public static void removeRequestPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Post Removed Successfully");
		alert.setContentText("Success! Your Post has been removed!");

		alert.showAndWait();
	}

	public static void removeRequestPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Remove Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}

	public static VBox getManageRequestPostScene() {
		
		ControlRequestPost ctrlPost = new ControlRequestPost();
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		VBox root = new VBox();
		
		Text title = new Text();
		title.setText("Manage My Post");
		
		Button removePostBTN = new Button("Remove Post");
		Button modifyPostBTN = new Button("Modify Post");
		Button backBTN = new Button("Back");
		
		Button okBTN = new Button("Ok");
		okBTN.setVisible(false);
		
		TextArea results = new TextArea();
		
		results.setMaxWidth(400);
		results.setEditable(false);
		results.setVisible(false);
		
		Text textRemove = new Text();
		textRemove.setText("Insert #id post to delete");
		textRemove.setVisible(false);
		
		Text textModify = new Text();
		textModify.setText("Insert #id post to modify");
		textModify.setVisible(false);
		
		TextField idField = new TextField();
		
		idField.setMaxWidth(350);
		idField.setAlignment(Pos.CENTER);
		idField.setPromptText("#ID");
		idField.setVisible(false);
		
		Text textNewTitolo = new Text();
		textNewTitolo.setText("Insert a new Title");
		textNewTitolo.setVisible(false);
		
		Text textNewDescrizione = new Text();
		textNewDescrizione.setText("Insert a new Description");
		textNewDescrizione.setVisible(false);
		
		TextField newTitoloField = new TextField();
		newTitoloField.setVisible(false);
		newTitoloField.setMaxWidth(350);
		newTitoloField.setAlignment(Pos.CENTER);
		newTitoloField.setPromptText("New Title");
		
		TextArea newDescrizioneField = new TextArea();
		newDescrizioneField.setPromptText("Description");
		newDescrizioneField.setMaxWidth(400);
		newDescrizioneField.setVisible(false);
		
		removePostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				cmd = 0;

				modifyPostBTN.setVisible(false);
				
				List<PostBean> postList = ctrlPost.filterRequestPostByUsername(win.getUser().getUsername());
				
				results.setVisible(true);
				
				int i;
								
				for(i=0; i<postList.size(); i++) {
										
					results.setText(results.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
							"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
				}
							
				textRemove.setVisible(true);
				idField.setVisible(true);
				
				okBTN.setVisible(true);
				
			}
		});
		
		modifyPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				cmd = 1;

				removePostBTN.setVisible(false);
				
				List<PostBean> postList = ctrlPost.filterRequestPostByUsername(win.getUser().getUsername());
				
				results.setVisible(true);
				
				int i;
								
				for(i=0; i<postList.size(); i++) {
										
					results.setText(results.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
							"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
				}
				
				textModify.setVisible(true);
				idField.setEditable(true);
				idField.setVisible(true);
				
				okBTN.setVisible(true);
			}
		});
		
		okBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				switch(cmd) {
				
					case 0: //remove
						
						int rem = ctrlPost.removeRequestPost(Integer.parseInt(idField.getText())-1);
						
						if(rem == -1) {
							
							removeRequestPostErrorAlert();
							
						} else {
							
							removeRequestPostAlert();
						}
						
						modifyPostBTN.setVisible(true);
						
						results.clear();
						results.setVisible(false);
						textRemove.setVisible(false);
						idField.clear();
						idField.setVisible(false);
						cmd = -1;
						
						win.loadMemberBandPage();
						
						break;
						
					case 1: //modify
						
						int res = ctrlPost.checkId(Integer.parseInt(idField.getText())-1);
						
						if(res == -1) {
							
							cmd = -1;
							
							removePostBTN.setVisible(true);
							
							results.clear();
							results.setVisible(false);
							textModify.setVisible(false);
							idField.clear();
							idField.setVisible(false);
							modifyRequestPostErrorAlert();
							win.loadMemberBandPage();
							break;
							
						}
						
						idField.setEditable(false);
						
						textNewTitolo.setVisible(true);
						textNewDescrizione.setVisible(true);
						
						newTitoloField.setVisible(true);
						newDescrizioneField.setVisible(true);
						
						cmd = 2;
							
						break;
					
					case 2:
						
						PostBean postBean = new PostBean();
						
						postBean.setTitolo(newTitoloField.getText());
						postBean.setDescrizione(newDescrizioneField.getText());
						
						int mod = ctrlPost.modifyRequestPost(postBean, Integer.parseInt(idField.getText()) -1);
						
						if(mod == -1) {
							
							modifyRequestPostErrorAlert();
							
						} else {
							
							modifyRequestPostAlert();
						}
						
						cmd = -1;
						
						removePostBTN.setVisible(true);
						
						results.clear();
						results.setVisible(false);
						textModify.setVisible(false);
						idField.clear();
						idField.setVisible(false);
						
						textNewTitolo.setVisible(false);
						textNewDescrizione.setVisible(false);
						newTitoloField.setVisible(false);
						newTitoloField.clear();
						newDescrizioneField.setVisible(false);
						newDescrizioneField.clear();
						
						win.loadMemberBandPage();
				}				
			}
		});
		
		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				results.clear();
				win.loadMemberBandPage();
			}
		});
		
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, modifyPostBTN, removePostBTN, results, textRemove, idField, textNewTitolo,	
				newTitoloField, textNewDescrizione, newDescrizioneField, okBTN, backBTN);

		return root;
	}

}
