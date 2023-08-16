package com.phyho.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phyho.web.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	// 2023-08-11 프레임워크 프로그래밍
	@GetMapping("/login")
	public String index() {
		return "login";
	}
	
	// 2023-08-16 프레임워크 프로그래밍
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, HttpSession session) {
		// 세션이 있다면 다른 곳으로 이동
		// id / pw 값이 없다면 다른 곳으로 이동
		// System.out.println(map);
		// {id=PYOPYO, pw=01234567}
		Map<String, Object> result = loginService.login(map);
		//System.out.println(result);
		// {m_name=PHYHO, count=1}
		
		if(String.valueOf(result.get("count")).equals("1")) {
			// 정상로그인이라면 세션만들고, index로 이동합니다.
			session.setAttribute("mid", map.get("id"));
			session.setAttribute("mname", result.get("m_name"));
			//System.out.println(session.getAttribute("mname"));
			return "redirect:/";
		} else {
			// 다시 로그인으로 가기
			return "login";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("mid") != null) {
			session.removeAttribute("mid");
		}
		if(session.getAttribute("mname") != null) {
			session.removeAttribute("mname");
		}
		// 다른
		session.invalidate();
		return "redirect:/";
	}
	
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
}
