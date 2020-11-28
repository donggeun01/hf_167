package com.spring.biz.admin.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.biz.admin.user.AdminUserDTO;

@Repository("adminUserDAO")
public class AdminUserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;


	public AdminUserDTO getAdminUser(AdminUserDTO vo) {
		Object[] args = { vo.getId(), vo.getPw() };
		return (AdminUserDTO) mybatis.selectOne("AdminUserDAO.getAdminUser", vo);
	}

	
}
