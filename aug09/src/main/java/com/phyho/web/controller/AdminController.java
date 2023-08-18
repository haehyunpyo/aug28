package com.phyho.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phyho.web.service.AdminService;
import com.phyho.web.util.Util;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// AdminService / AdminDAO / adminMapper
	// count, name, grade
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private Util util;
	
	@GetMapping("/")
	public String adminIndex2() {
		return "redirect:/admin/admin";
	}
	
	@GetMapping("/admin")
	public String adminIndex() {
		return "admin/index";
	}
	
	@PostMapping("/login")
	public String adminLogin(@RequestParam Map<String, Object> map, HttpSession session) {
		// System.out.println(map);
		Map<String, Object> result = adminService.adminLogin(map);
		System.out.println(result);
		// {m_grade=9, m_name=asdf, count=1}
		System.out.println(String.valueOf(result.get("count")).equals("1"));
		System.out.println(Integer.parseInt(String.valueOf(result.get("m_grade"))) > 5);
		
		if( util.obj2Int(result.get("count")) == 1	&&  util.obj2Int(result.get("m_grade")) > 5) {
			//System.out.println("진행");
			session.setAttribute("mid", map.get("id"));
			session.setAttribute("mname", result.get("m_name"));
			session.setAttribute("mgrade", result.get("m_grade"));
			// 메인으로 이동하기
			return "redirect:/admin/main";
		} else {
			return "redirect:/admin/admin?error=login";
		}

	}
	
	
}
