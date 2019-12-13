package com.iris.daos;

import java.util.List;

import com.iris.models.User;

public interface UserDao {
	public boolean registerUser(User uObj);
	public User loginUser(String email, String password);
	public User getSeller();
	public User getBuyer(int id);
	public List<User> getAllBuyers();
}
