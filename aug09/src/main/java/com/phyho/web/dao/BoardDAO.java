package com.phyho.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.phyho.web.dto.BoardDTO;

@Repository
@Mapper
public interface BoardDAO {

	List<BoardDTO> boardList();
	
}
