package com.bitacademy.jblog.repository;

import java.util.List;

import com.bitacademy.jblog.vo.CateVo;


public interface CategoryDao {
	
	public List<CateVo> selectAll(Long userNo);
	public CateVo getContent(Long cateNo);
	public int insert(CateVo vo);
	public int delete(Long cateNo);
}
