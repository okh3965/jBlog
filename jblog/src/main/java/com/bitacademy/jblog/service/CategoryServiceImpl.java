package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryDao;
import com.bitacademy.jblog.vo.CateVo;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	CategoryDao categoryDaoImpl;
	
	@Override
	public List<CateVo> getList(Long userNo) {
		List<CateVo> list = categoryDaoImpl.selectAll(userNo);
		return list;
	}
	
	@Override
	public CateVo getContent(Long cateNo) {
		// TODO Auto-generated method stub
		CateVo vo = categoryDaoImpl.getContent(cateNo);
		return vo;
	}

	@Override
	public boolean writeCategory(CateVo vo) {
		int insertedCount = categoryDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public boolean deleteCategory(Long cateNo) {
		int deletedCount = categoryDaoImpl.delete(cateNo);
		return 1 == deletedCount;
	}

}
