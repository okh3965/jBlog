package com.bitacademy.jblog.repository;

import com.bitacademy.jblog.vo.BlogVo;

public interface BlogDao {
	
	public BlogVo getContent(Long userNo);
	public BlogVo getContentById(String id);
	public int insert(BlogVo vo);
	public int update(BlogVo vo);

}
