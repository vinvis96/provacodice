package logic.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import logic.bean.UserBean;
import logic.dao.UserDAO;

public class ControlRegister {

	public int registerUser(UserBean usBean) {
		
		String subsDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
		
		usBean.setSubsDate(subsDate);

		UserDAO.registerUser(usBean);
		
		return 1;
		
	}

	public String checkUsernameAlreadyTaken(String username) {

		String result = UserDAO.checkUsernameAlreadyTaken(username);

		return result;
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
