package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.vo.BlogVo;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDaoImpl;
	
	@Override
	public BlogVo getContent(Long userNo) {
		
		BlogVo vo = blogDaoImpl.getContent(userNo);
		return vo;
	}
		
	@Override
	public BlogVo getContent(String id) {
		// TODO Auto-generated method stub
		BlogVo vo = blogDaoImpl.getContentById(id);
		return vo;
	}

	@Override
	public boolean insert(BlogVo vo) {
		int insertedCount = blogDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public boolean update(BlogVo vo) {
		int updatedCount = blogDaoImpl.update(vo);
		return 1 == updatedCount;
	}
	
	

}
