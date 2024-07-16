package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepositoty;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionJDBCUtil;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoty {

	public static void joinTable(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
		String staffId = (String) params.get("staffId");
		if (StringUtil.checkString(staffId)) {
			sql.append(" INNER JOIN assignmentbuilding ab ON b.id = ab.buildingid ");
		}
		if (typeCode != null && typeCode.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype brt ON b.id = brt.buildingid ");
			sql.append(" INNER JOIN renttype rt ON rt.id = brt.renttypeid ");
		}
		String rentAreaFrom = (String) params.get("rentAreaFrom");
		String rentAreaTo = (String) params.get("rentAreaTo");
		if (StringUtil.checkString(rentAreaFrom) || StringUtil.checkString(rentAreaTo)) {
			sql.append(" INNER JOIN rentarea ra ON ra.buildingid = b.id ");
		}
	}

	public static void queryNormal(Map<String, Object> params, StringBuilder where) {
		for (Map.Entry<String, Object> it : params.entrySet()) {
			if (!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") && !it.getKey().startsWith("rentArea")
					&& !it.getKey().startsWith("rentPrice")) {
				String value = it.getValue().toString();
				if (StringUtil.checkString(value)) {
					if (NumberUtil.isNumber(value)) {
						where.append(" AND b." + it.getKey() + " = " + value);
					} else {
						where.append(" AND b." + it.getKey() + " LIKE '%" + value + "%' ");
					}
				}
			}
		}
	}

	public static void querySpecial(Map<String, Object> params, List<String> typeCode, StringBuilder where) {
		String staffId = (String) params.get("staffId");
		if (StringUtil.checkString(staffId)) {
			where.append(" AND ab.staffid = " + staffId);
		}
		String rentAreaFrom = (String) params.get("rentAreaFrom");
		String rentAreaTo = (String) params.get("rentAreaTo");
		if (StringUtil.checkString(rentAreaFrom)) {
			where.append(" AND ra.value >=" + rentAreaFrom);
		}
		if (StringUtil.checkString(rentAreaTo)) {
			where.append(" AND ra.value <=" + rentAreaTo);
		}
		String rentPriceFrom = (String) params.get("rentPriceFrom");
		String rentPriceTo = (String) params.get("rentPriceTo");
		if (StringUtil.checkString(rentPriceFrom)) {
			where.append(" AND b.rentprice >=" + rentPriceFrom);
		}
		if (StringUtil.checkString(rentPriceTo)) {
			where.append(" AND b.rentprice <=" + rentPriceTo);
		}
//		java 7
		if (typeCode != null && typeCode.size() != 0) {
			List<String> codeList = new ArrayList<String>();
			for (String item : typeCode) {
				codeList.add("'" + item + "'");
			}
			where.append(" AND rt.code IN(" + String.join(",", codeList) + ") ");
		}
	}

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode) {
		StringBuilder sql = new StringBuilder(
				"SELECT b.id, b.name, b.districtid, b.street, b.ward, b.numberofbasement, b.floorarea, b.rentprice, "
						+ "b.managername, b.managerphonenumber, b.servicefee, b.brokeragefee FROM building b ");
		joinTable(params, typeCode, sql);
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		queryNormal(params, where);
		querySpecial(params, typeCode, where);
		where.append(" GROUP BY b.id ");
		sql.append(where);
		List<BuildingEntity> result = new ArrayList<>();
		try (Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getLong("b.id"));
				buildingEntity.setName(rs.getString("b.name"));
				buildingEntity.setWard(rs.getString("b.ward"));
				buildingEntity.setDistrictId(rs.getLong("b.districtid"));
				buildingEntity.setStreet(rs.getString("b.street"));
				buildingEntity.setFloorArea(rs.getLong("b.floorarea"));
				buildingEntity.setRentPrice(rs.getLong("b.rentprice"));
				buildingEntity.setServiceFee(rs.getString("b.servicefee"));
				buildingEntity.setBrokerageFee(rs.getLong("b.brokeragefee"));
				buildingEntity.setManagerName(rs.getString("b.managername"));
				buildingEntity.setManagerPhoneNumber(rs.getString("b.managerphonenumber"));
				result.add(buildingEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
