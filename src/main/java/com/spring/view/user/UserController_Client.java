package com.spring.view.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.biz.user.UserDTO;
import com.spring.biz.user.UserService;

@Controller
public class UserController_Client {
	@Autowired //UserService Ÿ���� UserServiceImpl ��ü�� ������ ���Եȴ�.
	private UserService userService;
	
	@RequestMapping(value="/login.do")
	@ResponseBody	//	�޼ҵ忡 @ResponseBody �� ������̼��� �Ǿ� �ִٸ� �޼ҵ忡�� ���ϵǴ� ���� View �� ���ؼ� ��µ��� �ʰ� HTTP Response Body �� ���� �������� �˴ϴ�.
	public Map<String, String> login(HttpServletRequest request) {
		//Ŭ���̾�Ʈ�� ���� �ڷᱸ�� Map
		Map<String, String> result = new HashMap<String, String>();
		
		//Ŭ���̾�Ʈ��(�Ű������� &�� �̿��� get��������� Post������� ����) ���� ���� �Ű�����
		String e_mail = request.getParameter("e_mail");
		String password = request.getParameter("password");
		
		//DB ���� (Ŭ���̾�Ʈ�� ����� ���� String�̴� ������ Ÿ�Ժ�ȯ���ֱ� �ٶ�)
		UserDTO vo = new UserDTO();
		vo.setE_mail(e_mail);
		vo.setPassword(password);
				
		return userService.getUser_client(e_mail, password);
	}
	
	@RequestMapping(value = "/user_register.do")
	@ResponseBody
	public String register(HttpServletRequest request) {
		
		String e_mail = request.getParameter("e_mail");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		
		UserDTO vo = new UserDTO();
		vo.setE_mail(e_mail);
		vo.setPassword(password);
		vo.setName(name);
		vo.setPhone(phone);
		vo.setSex(sex);
		vo.setAge(Integer.parseInt(age));
		
		
		return userService.insertUser_clinet(vo);
	}
	
	@RequestMapping(value = "/user_address_update.do")
	@ResponseBody
	public String address_update(HttpServletRequest request) {
		String isDetail = request.getParameter("isDetail");
		String e_mail = request.getParameter("e_mail");
		String address = request.getParameter("address");
		String address_detail = request.getParameter("address_detail");
		return userService.updateUser_client(isDetail, e_mail, address, address_detail);
		
	}
}