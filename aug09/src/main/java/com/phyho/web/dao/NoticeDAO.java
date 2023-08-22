package com.phyho.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeDAO {

	List<Map<String, Object>> list();

	Map<String, Object> detail(int nno);

	String nWriter(int nno);

	String getOriFileName(String filename);
	
}
