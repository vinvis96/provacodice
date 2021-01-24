package logic.control;

import logic.bean.UserBean;
import logic.dao.UserDAO;
import logic.utils.MailSender;

public class ControlRecoverData {

	public int sendEmail(UserBean usBean) {
		
		String password;
				
		password = UserDAO.checkEmail(usBean);
		
		if(password != null) {
			
			MailSender ms = new MailSender();

			ms.sendMail(usBean.getEmail(), usBean.getUsername(), password);
			return 1;
		
		} else {
			
			return -1;
		}
		
	}

}
