package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.PostDao;
import com.bitacademy.jblog.vo.PostVo;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostDao postDaoImpl;
	
	@Override
	public List<PostVo> getList(Long cateNo) {
		// TODO Auto-generated method stub
		List<PostVo> list = postDaoImpl.selectAll(cateNo);
		return list;
	}
	

	@Override
	public PostVo getContent(Long postNo) {
		// TODO Auto-generated method stub
		PostVo vo = postDaoImpl.getContent(postNo);
		return vo;
	}

	@Override
	public PostVo getLateContent(Long userNo) {
		// TODO Auto-generated method stub
		PostVo vo = postDaoImpl.getLateContent(userNo);
		return vo;
	}

	@Override
	public boolean insert(PostVo vo) {
		
		int insertedCount = postDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public boolean delete(PostVo vo) {

		int deletedCount = postDaoImpl.delete(vo);
		return 1 == deletedCount;
	}

}
