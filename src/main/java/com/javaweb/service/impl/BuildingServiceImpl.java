package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepositoty;

	@Autowired
	private BuildingDTOConverter buildingDTOConverter;

	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

	@Override
	public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		// TODO Auto-generated method stub
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(params,
				typeCode);
		List<BuildingEntity> buildingEntities = buildingRepositoty.findAll(buildingSearchBuilder); // findById -> findOne																									// findOne
		List<BuildingDTO> resultBuildingDTOs = new ArrayList<BuildingDTO>();
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = buildingDTOConverter.toBuildingDTO(item);
			resultBuildingDTOs.add(buildingDTO);
		}
		return resultBuildingDTOs;
	}

}
