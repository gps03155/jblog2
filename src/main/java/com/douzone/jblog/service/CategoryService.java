package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.CategoryDao;
import com.douzone.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	public void insertCategory(long userNo) {
		categoryDao.insertCategory(userNo);
	}
	
	public int addCategory(String id, String name, String desc) {
		return categoryDao.addCategory(id, name, desc);
	}
	
	public long lastInsert() {
		return categoryDao.lastInsert();
	}
	
	public List<CategoryVo> selectCategory(String id){
		return categoryDao.selectCategory(id);
	}
	
	public CategoryVo getInsert(long no) {
		return categoryDao.getInsert(no);
	}
	
	public int deleteCategory(String id, long no) {
		return categoryDao.deleteCategory(id, no);
	}
	
	public List<CategoryVo> getCategoryName(String id){
		return categoryDao.getCategoryName(id);
	}
	
	public long getCategoryNo(String id, String categoryName) {
		return categoryDao.getCategoryNo(id, categoryName);
	}
	
	public long countPost(long categoryNo) {
		return categoryDao.countPost(categoryNo);
	}
}
