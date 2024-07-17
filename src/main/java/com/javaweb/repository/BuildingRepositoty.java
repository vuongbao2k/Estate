package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepositoty {
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
