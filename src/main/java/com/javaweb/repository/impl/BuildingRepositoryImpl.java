package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepositoty;
import com.javaweb.repository.entity.BuildingEntity;

import ch.qos.logback.core.db.dialect.SybaseSqlAnywhereDialect;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoty {
	static final String DB_URL = "jdbc:mysql://localhost:3307/estatebasic";
	static final String USER = "root";
	static final String PASS = "1234";

	@Override
	public List<BuildingEntity> findAll(String name, Long districtId) {
		StringBuilder sql = new StringBuilder("select * from building b where 1=1 ");
		if (name !=null && !name.equals("")) {
			sql.append("and b.name like '%"+ name + "%' ");
		}
		if (districtId !=null) {
			sql.append("and b.districtid =" + districtId +" ");
		}
		List<BuildingEntity> result = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				result.add(building);
			}
//			System.out.println("Successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("Connected db failed...");
		}
		return result;
	}

}
