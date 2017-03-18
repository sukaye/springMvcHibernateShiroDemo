package com.sk.test.service;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.sk.common.Log;
import me.sk.entity.Permissions;
import me.sk.entity.Role;
import me.sk.entity.User;
import me.sk.service.LoginService;

/**
 * LoginService 测试类
 * 
 * @author SK
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-config/spring-core.xml"})
public class LoginServiceTest {
	@Autowired
	LoginService loginService;
	
	@Test
	public void test() {
//		Log.debug("print here.....boolean="+loginService.login("scott", "scott"));;
		User user = loginService.getUser("scott");
		Set<Role> roleSet = user.getRoleses();
		for (Role role : roleSet) {
			Log.info("role="+role.getRole());
			for (Permissions pers : role.getPermissionses()) {
				Log.info("permissions="+pers.getPermission());
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
