package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertCategory(long userNo) {
		sqlSession.insert("category.insertCategory", userNo);
	}

	public int addCategory(String id, String name, String desc) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", id);
		map.put("name", name);
		map.put("description", desc);
		
		return sqlSession.insert("category.addCategory", map);
	}
	
	public long lastInsert() {
		return sqlSession.selectOne("category.lastInsert");
	}
	
	public List<CategoryVo> selectCategory(String id) {
		return sqlSession.selectList("category.selectCategory", id);
	}
	
	public CategoryVo getInsert(long no) {
		return sqlSession.selectOne("category.getInsert", no);
	}
	
	public int deleteCategory(String id, long no) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("no", no);
		
		return sqlSession.delete("category.deleteCategory", map);
	}
	
	public List<CategoryVo> getCategoryName(String id){
		return sqlSession.selectList("category.getCategoryName", id);
	}
	
	public long getCategoryNo(String id, String categoryName) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", id);
		map.put("name", categoryName);
		
		return sqlSession.selectOne("category.getCategoryNo", map);
	}
	
	public long countPost(long categoryNo) {
		return sqlSession.selectOne("category.countPost", categoryNo);
	}
}
