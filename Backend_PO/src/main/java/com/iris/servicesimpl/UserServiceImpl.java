package com.iris.servicesimpl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.services.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public boolean registerUser(User uObj) {
		uObj.setRole("Buyer");
		uObj.setCreatedDate(LocalDate.now());
		uObj.setCreatedBy("System");
		uObj.setIsActive("Y");
		return userDao.registerUser(uObj);	
	}

	public User loginUser(String email, String password) {
		User uObj=userDao.loginUser(email, password);
		return uObj;
	}

	public User getSeller() {
		return userDao.getSeller();
	}
	
	public User getBuyer(int id) {
		return userDao.getBuyer(id);
	}

	public List<User> getAllBuyers() {
		return userDao.getAllBuyers();
	}
	
}
