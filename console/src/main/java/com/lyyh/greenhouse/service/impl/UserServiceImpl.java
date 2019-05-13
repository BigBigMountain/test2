package com.lyyh.greenhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyyh.greenhouse.dao.UserDao;
import com.lyyh.greenhouse.pojo.User;
import com.lyyh.greenhouse.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> queryAll() {
		
		return userDao.queryAll();
	}
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	@Override
	public void delById(Integer userId) {
		userDao.delById(userId);
	}

}
