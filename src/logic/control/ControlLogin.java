package logic.control;

import logic.bean.UserBean;
import logic.dao.UserDAO;
import logic.interfaces.IUser;
import logic.patterns.FactoryUser;
import logic.utils.WindowManagerGUI;

public class ControlLogin {

	public int checkIfRegistered(UserBean usBean) {
		
		int type;
		FactoryUser factory = new FactoryUser();
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		type = UserDAO.checkIfRegistered(usBean);
		IUser user = factory.createUser(type);
		
		if(type == -1) {
			
			return -1;
			
		} else {
			
			user.setUsername(usBean.getUsername());
			win.setUser(user);
			return 1;
		}
	}
}
