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
	@Autowired //UserService 타입의 UserServiceImpl 객체가 의존성 주입된다.
	private UserService userService;
	
	@RequestMapping(value="/login.do")
	@ResponseBody	//	메소드에 @ResponseBody 로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은 View 를 통해서 출력되지 않고 HTTP Response Body 에 직접 쓰여지게 됩니다.
	public Map<String, String> login(HttpServletRequest request) {
		//클라이언트로 보낼 자료구조 Map
		Map<String, String> result = new HashMap<String, String>();
		
		//클라이언트로(매개변수와 &을 이용한 get방식이지만 Post방식으로 받음) 부터 받은 매개변수
		String e_mail = request.getParameter("e_mail");
		String password = request.getParameter("password");
		
		//DB 접근 (클라이언트와 통신할 때는 String이다 적절히 타입변환해주길 바람)
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
