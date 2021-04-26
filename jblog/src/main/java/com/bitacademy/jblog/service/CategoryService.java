package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.CateVo;

public interface CategoryService {
	
	public List<CateVo> getList(Long userNo);
	public CateVo getContent(Long cateNo);
	public boolean writeCategory(CateVo vo);
	public boolean deleteCategory(Long cateNo);

}
