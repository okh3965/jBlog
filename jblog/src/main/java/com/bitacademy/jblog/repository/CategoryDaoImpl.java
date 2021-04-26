package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.CateVo;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<CateVo> selectAll(Long userNo) {
		// TODO Auto-generated method stub
		List<CateVo> list = sqlSession.selectList("category.selectAll", userNo);
		System.out.println("------------");
		System.out.println(list);
		
//		logger.debug("카테고리:" + list);
		return list;	}

	
	@Override
	public CateVo getContent(Long cateNo) {
		// TODO Auto-generated method stub
		CateVo vo = sqlSession.selectOne("category.getContent", cateNo);
		return vo;
	}

	@Override
	public int insert(CateVo vo) {
		int insertedCount = sqlSession.insert("category.insert", vo);
		return insertedCount;
	}

	@Override
	public int delete(Long cateNo) {
		int deletedCount = sqlSession.delete("category.delete", cateNo);
		return deletedCount;
	}

}
