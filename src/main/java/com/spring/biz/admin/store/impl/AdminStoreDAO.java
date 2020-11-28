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
	
	
// ���Ը�� 
	public AdminStoreDTO getAdminStore(AdminStoreDTO vo){
		return (AdminStoreDTO)mybatis.selectOne("AdminStoreDAO.getAdminStore",vo);
	}
	
// �������� ����
	public void updateStore(AdminStoreDTO vo) {
		mybatis.update("AdminStoreDAO.updateStore", vo);
	}
//�޴� ���
	public List<AdminStoreMenuDTO> getMenuList(AdminStoreMenuDTO vo) {
		return mybatis.selectList("AdminStoreDAO.getMenuList", vo);
	}

// �޴� �߰�
	public void insertMenu(AdminStoreMenuDTO vo) {
		if (vo.getType() == 0) {
			mybatis.insert("AdminStoreDAO.insertMenu_BAR", vo);
		}
		else if(vo.getType() == 1) {
			
			mybatis.insert("AdminStoreDAO.insertMenu", vo);
		}
	}	
// �޴� ����
	public void deleteMenu(AdminStoreMenuDTO vo) {
		mybatis.delete("AdminStoreDAO.deleteMenu", vo);
	}	
	
// ���� ����
	public void updateCondition(AdminStoreDTO vo) {
		mybatis.update("AdminStoreDAO.updateCondition", vo);
	}
	
	

}


