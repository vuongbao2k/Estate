package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepositoty;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepositoty buildingRepositoty;
	
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

	@Override
	public List<BuildingDTO> findAll(Map<String,Object> params, List<String> typeCode) {
		// TODO Auto-generated method stub
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeCode);
		BuildingEntity buildingEntities = buildingRepositoty.findOne(1L); //findById -> findOne
		List<BuildingDTO> resultBuildingDTOs = new ArrayList<BuildingDTO>();
//		for (BuildingEntity item : buildingEntities) {
//			BuildingDTO buildingDTO = buildingDTOConverter.toBuildingDTO(item);
//			resultBuildingDTOs.add(buildingDTO);
//		}
		return resultBuildingDTOs;
	}

}
