package logic.control;

import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.bean.UserBean;
import logic.dao.UserDAO;
import logic.entity.User;
import logic.utils.WindowManagerGUI;

public class ControlProfile {
	
	public void modifyUserDataAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("User Data Modified Successfully");
		alert.setContentText("Success! Your data has been modified!");

		alert.showAndWait();
	}


	public UserBean getCurrentUserData() {
		
		int i;
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		UserBean userBean = new UserBean();
		List<User> userList = UserDAO.getUserList();
		
		for(i=0; i<userList.size(); i++) {
			
			if(userList.get(i).getUsername().equals(win.getUser().getUsername())) {
				
				userBean.setUsername(userList.get(i).getUsername());
				userBean.setPassword(userList.get(i).getPassword()); //Sarebbe meglio di no
				userBean.setEmail(userList.get(i).getEmail());
				userBean.setFirstname(userList.get(i).getFirstname());
				userBean.setLastname(userList.get(i).getLastname());
				userBean.setSubsDate(userList.get(i).getSubsDate());
				userBean.setBirthDate(userList.get(i).getBirthDate());
				userBean.setZone(userList.get(i).getZone());
				userBean.setInstrPlayed(userList.get(i).getInstrPlayed());
				userBean.setBand(userList.get(i).getBand());
				userBean.setNameBand(userList.get(i).getNameBand());
				
			}
		}
		
		return userBean;
	}

	public void modifyCurrentUserProfile(UserBean user) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		int i;
		List<User> userList = UserDAO.getUserList();
		
		for(i=0;i<userList.size();i++) {
			
			if(userList.get(i).getUsername().equals(win.getUser().getUsername())) {
				
				UserDAO.modifyProfile(user);
				modifyUserDataAlert();
			}
		}
		
	}
}
