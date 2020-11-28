package com.spring.biz.admin.store.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.admin.store.AdminStoreDTO;
import com.spring.biz.admin.store.AdminStoreMenuDTO;

@Repository("adminStoreDAO")
public class AdminStoreDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	/*
	 * public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	 * super.setSqlSessionFactory(sqlSessionFactory); }
	 */
	
	
// 가게목록 
	public AdminStoreDTO getAdminStore(AdminStoreDTO vo){
		return (AdminStoreDTO)mybatis.selectOne("AdminStoreDAO.getAdminStore",vo);
	}
	
// 가게정보 수정
	public void updateStore(AdminStoreDTO vo) {
		mybatis.update("AdminStoreDAO.updateStore", vo);
	}
//메뉴 목록
	public List<AdminStoreMenuDTO> getMenuList(AdminStoreMenuDTO vo) {
		return mybatis.selectList("AdminStoreDAO.getMenuList", vo);
	}

// 메뉴 추가
	public void insertMenu(AdminStoreMenuDTO vo) {
		if (vo.getType() == 0) {
			mybatis.insert("AdminStoreDAO.insertMenu_BAR", vo);
		}
		else if(vo.getType() == 1) {
			
			mybatis.insert("AdminStoreDAO.insertMenu", vo);
		}
	}	
// 메뉴 삭제
	public void deleteMenu(AdminStoreMenuDTO vo) {
		mybatis.delete("AdminStoreDAO.deleteMenu", vo);
	}	
	
// 조건 수정
	public void updateCondition(AdminStoreDTO vo) {
		mybatis.update("AdminStoreDAO.updateCondition", vo);
	}
	
	

}


