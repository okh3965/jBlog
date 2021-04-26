package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.PostVo;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<PostVo> selectAll(Long cateNo) {
		// TODO Auto-generated method stub
		List<PostVo> list = sqlSession.selectList("post.selectAll", cateNo);
		return list;
	}
	
	
	@Override
	public PostVo getContent(Long postNo) {
		// TODO Auto-generated method stub
		PostVo vo = sqlSession.selectOne("post.getContent", postNo);		
		return vo;
	}

	

	@Override
	public PostVo getLateContent(Long userNo) {
		// TODO Auto-generated method stub
		PostVo vo = sqlSession.selectOne("post.getLateContent", userNo);
		return vo;
	}


	@Override
	public int insert(PostVo vo) {

		int insertedCount = sqlSession.insert("post.insert", vo);
		return insertedCount;
	}

	@Override
	public int delete(PostVo vo) {
		
		int deletedCount = sqlSession.delete("post.delete", vo);
		return deletedCount;
	}

}
