package me.sk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.sk.dao.LoginDao;
import me.sk.entity.User;;;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;
	
	public boolean login(String loginName, String password) {
		return loginDao.login(loginName, password);
	}

	@Override
	public User getUser(String loginName) {
		return loginDao.getUser(loginName);
	}
}
