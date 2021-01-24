package logic.control;

import java.util.List;
import java.util.regex.Pattern;

import logic.bean.UserBean;
import logic.dao.UserDAO;
import logic.entity.User;
import logic.utils.WindowManagerGUI;

public class ControlProfile {

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

	public int modifyCurrentUserProfile(UserBean user) {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		int i;
		List<User> userList = UserDAO.getUserList();
		
		int check = -1;
		
		for(i=0;i<userList.size();i++) {
			
			if(userList.get(i).getUsername().equals(win.getUser().getUsername())) {
				
				UserDAO.modifyProfile(user);
				check = 1;
			}
		}
		
		return check;
		
	}
	
	public boolean checkIfEmailIsValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
}
