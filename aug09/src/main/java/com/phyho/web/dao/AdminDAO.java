package com.phyho.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.servlet.ModelAndView;

@Mapper
public interface AdminDAO {

	Map<String, Object> adminLogin(Map<String, Object> map);

	List<Map<String, Object>> list();

	void noticeWrite(Map<String, Object> map);

	String noticeDetail(int nno);

	int noticeHide(int nno);

	List<Map<String, Object>> setupboardList();

	int multiBoardInsert(Map<String, Object> map);

	List<Map<String, Object>> memberList();

	int gradeChange(Map<String, Object> map);

	List<Map<String, Object>> post(Map<String, Object> map);

	List<Map<String, Object>> boardList();

	String postDetail(int mbno);

}



