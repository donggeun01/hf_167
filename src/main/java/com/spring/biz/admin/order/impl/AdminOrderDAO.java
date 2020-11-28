package com.spring.biz.admin.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.admin.order.AdminOrderCntDTO;
import com.spring.biz.admin.order.AdminOrderDTO;
import com.spring.biz.admin.store.AdminStoreDTO;

@Repository("adminOrderDAO")
public class AdminOrderDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public String getPhone(String phone) {
		String e_mail = phone;
		return mybatis.selectOne("AdminOrderDAO.getPhone", e_mail);
	}
	
	public List<AdminOrderDTO> getOrder_List(AdminOrderDTO vo) {
		Object[] args = {vo.getStore_name()};
		return mybatis.selectList("AdminOrderDAO.getOrder_List", vo);
	}
	
	public void typeUpdate(AdminOrderDTO vo)  {
		mybatis.update("AdminOrderDAO.typeUpdate", vo);
	}
	
	public List<AdminOrderDTO> getOrderLog_List(AdminOrderDTO vo) {
		Object[] args = {vo.getStore_name()};
		return mybatis.selectList("AdminOrderDAO.getOrderLog_List", vo);
	}
	
	public List<AdminOrderDTO> sumRegular_list(AdminStoreDTO vo){
		Object[] args = {vo.getCondition_day(), vo.getName()};
		return mybatis.selectList("AdminOrderDAO.sumRegular_List", vo);
	}
	
	public List<AdminOrderCntDTO> countRegular_list(AdminStoreDTO vo){
		Object[] args = {vo.getCondition_day(), vo.getName()};
		return mybatis.selectList("AdminOrderDAO.countRegular_List", vo);
	}
	

}
