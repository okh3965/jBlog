package com.bitacademy.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.BlogVo;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public BlogVo getContent(Long userNo) {
		BlogVo vo = sqlSession.selectOne("blog.getContent", userNo);
		return vo;
	}

	@Override
	public BlogVo getContentById(String id) {
		// TODO Auto-generated method stub
		BlogVo vo = sqlSession.selectOne("blog.getContentById", id);
		return vo;
	}

	@Override
	public int insert(BlogVo vo) {
		int insertedCount = sqlSession.insert("blog.insert", vo);
		return insertedCount;
	}
	
	@Override
	public int update(BlogVo vo) {
		int updatedCount = sqlSession.update("blog.update", vo);
		return updatedCount;
	}



}
