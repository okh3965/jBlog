package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.PostVo;

public interface PostService {
	
	public List<PostVo> getList(Long cateNo);
	public PostVo getContent(Long postNo);
	public PostVo getLateContent(Long userNo);
	public boolean insert(PostVo vo);
	public boolean delete(PostVo vo);

}
