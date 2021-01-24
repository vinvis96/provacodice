package logic.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.PostBean;
import logic.control.ControlTopicPost;

public class InsertTopicPostGUI {

	public static VBox getInsertTopicPostScene() {

		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		ControlTopicPost ctrlTopicPost = new ControlTopicPost();

		VBox root = new VBox();
		Text title = new Text();
		title.setText("Inserting New Post");
		
		TextField titlePostField = new TextField();	
		titlePostField.setMaxWidth(350);
		titlePostField.setAlignment(Pos.CENTER);
		titlePostField.setPromptText("Title of the post");
		
		TextField topicPostField = new TextField();
		topicPostField.setMaxWidth(350);
		topicPostField.setAlignment(Pos.CENTER);
		topicPostField.setPromptText("Topic of the post");
		
		TextArea descriptionField = new TextArea();	
		descriptionField.setMaxWidth(350);
		descriptionField.setPromptText("Description");

		Button backBTN = new Button("Back");
		
		Button insertPostBTN = new Button("Insert Post");


		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				titlePostField.clear();
				descriptionField.clear();
				topicPostField.clear();

				win.loadTopicPage();
			}
		});

		insertPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {		
					
					PostBean post = new PostBean();
					
					post.setAutore(win.getUser().getUsername());
					post.setTitolo(titlePostField.getText());
					post.setArgomento(topicPostField.getText());
					post.setDescrizione(descriptionField.getText());
					
					ctrlTopicPost.insertTopicPost(post);
					
					titlePostField.clear();
					descriptionField.clear();
					topicPostField.clear();
					
					win.loadTopicPage();

			}
		});

		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, titlePostField, topicPostField, descriptionField, insertPostBTN, backBTN);

		return root;
	}

}
