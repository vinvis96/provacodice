package logic.boundary;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.PostBean;
import logic.control.ControlRequestPost;
import logic.utils.WindowManagerGUI;

public class MemberBandRequestGUI {

	public static VBox getMemberBandScene() {
		
		
		int i;
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		ControlRequestPost ctrlRequest = new ControlRequestPost();

		VBox root = new VBox();
		HBox box = new HBox();
		
		List<PostBean> postList = ctrlRequest.getRequestPosts();
		
		Text title = new Text();
		
		title.setText("Band/Member Post GUI");
		
		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button backBTN = new Button("Back");
		Button newPostBTN = new Button("New Post");
		Button findPostBTN = new Button("Search Post");
		Button manageMyPostBTN = new Button("Manage My Posts");
		
		TextArea posts = new TextArea();
		
		posts.setMaxWidth(400);
		posts.setEditable(false);
		
		if(postList.size() == 0) {
			
			posts.setText("No Band/Member Posts in the system");
			
		} else {
			
			for(i=0; i<postList.size(); i++) {
				
				posts.setText(posts.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
						"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
			}
			
		}

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadHomePage();
			}
		});

		newPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadInsertRequestPostPage();

			}
		});
		
		manageMyPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadManageRequestPostPage();

			}
		});
		
		findPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadFindPostPage(2);

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

		box.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		box.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		root.getChildren().addAll(title, box, posts, newPostBTN, manageMyPostBTN, findPostBTN, backBTN);

		return root;
	
	}

}
