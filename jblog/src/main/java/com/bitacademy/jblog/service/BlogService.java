package com.bitacademy.jblog.service;

import com.bitacademy.jblog.vo.BlogVo;

public interface BlogService {
	
	public BlogVo getContent(Long userNo);
	public BlogVo getContent(String id);
	public boolean insert(BlogVo vo);
	public boolean update(BlogVo vo);	//기본설정 업데이트용


}
