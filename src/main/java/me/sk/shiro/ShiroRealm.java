package me.sk.shiro;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import me.sk.entity.Permissions;
import me.sk.entity.Role;
import me.sk.entity.User;
import me.sk.service.LoginService;

public class ShiroRealm extends AuthorizingRealm {
	// 用于获取用户信息及用户权限信息的业务接口
	
	final static String REALM_NAME = "ShiroRealm";
	
	@Autowired
	LoginService loginService;

	// 获取授权信息
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = (String) principals.fromRealm(getName()).iterator().next();
		User user = loginService.getUser(userName);
		Collection<Role> roles = null;
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (userName != null && user != null) {
			roles = user.getRoleses();
			if (roles != null && !roles.isEmpty()) {
				for (Role role : roles) {
					info.addRole(role.getRole());
				}
			}

			// 查询用户授权信息
			Set<Permissions> persSet = new HashSet<>();
			Set<String> pers = new HashSet<>();
			if (roles != null && !roles.isEmpty()) {
				for (Role role : roles) {
					persSet.addAll(role.getPermissionses());
				}
				for (Permissions per : persSet) {
					pers.add(per.getPermission());
				}
			}
			if (pers != null && !pers.isEmpty()) {
				for (String each : pers) {
					info.addStringPermission(each);
				}

			}
			return info;
		} else {
			return null;
		}
	}

	// 获取认证信息
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// 通过表单接收的用户名
		String userName = token.getUsername();

		if (userName != null && !"".equals(userName)) {
			User user = loginService.getUser(userName);

			if (user != null) {
				return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
			}
		}

		return null;
	}
}
