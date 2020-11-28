package com.spring.view.admin.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.admin.user.AdminUserDTO;
import com.spring.biz.admin.user.AdminUserService;

@Controller
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;

	@RequestMapping(value = "/adminLogin.do", method = RequestMethod.POST)
	public String login(AdminUserDTO vo, HttpSession session) {
		try {
			AdminUserDTO userVO = adminUserService.getAdminUser(vo);
			if (userVO.getStore_name() != null) {
				session.setAttribute("adminUser", userVO);
			}
		} catch (NullPointerException e) {
			System.out.println("오류 메세지");
			return "adminLogin.jsp";
		}
		return "getAdminStore.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "adminLogin.jsp";
	}
}
