package com.phyho.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	// 2023-08-18 요구사항 확인
	// @PathVariable 사용법
	@GetMapping("/myinfo@{id}")
	public ModelAndView myInfo(@PathVariable("id") String id, HttpSession session) {
		System.out.println("jsp가 보내준 값 : " + id);
		System.out.println(id.equals(session.getAttribute("mid")));
		// 회원가입할때 개인정보 수정할때 암호 암호화하기
		Map<String, Object> myInfo = loginService.myInfo(id);
		ModelAndView mv = new ModelAndView();	// 객체 선언 = jsp명이 없는 상태
		mv.setViewName("myinfo");	// 이동할 jsp파일명
		mv.addObject("my", myInfo);	// 값 붙이기
		return mv;
	}
	
	
}
