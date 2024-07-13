package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepositoty {
	List<BuildingEntity> findAll(String name, Long districtId);
}
