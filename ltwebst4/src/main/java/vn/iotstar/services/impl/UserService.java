package vn.iotstar.services.impl;

import jakarta.servlet.annotation.WebServlet;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;


@WebServlet (urlPatterns = {"/waiting"})
public class UserService implements IUserService {
//lấy toàn bộ hàm trong tầng Dao của user
	IUserDao userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
			}
			return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByUserName(username);
	}

}
