package com.bitacademy.jblog.repository;

import java.util.List;

import com.bitacademy.jblog.vo.PostVo;

public interface PostDao {
	
	public List<PostVo> selectAll(Long cateNo);
	public PostVo getContent(Long postNo);
	public PostVo getLateContent(Long userNo);
	public int insert(PostVo vo);
	public int delete(PostVo vo);

}
