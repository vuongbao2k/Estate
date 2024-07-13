package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepositoty;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepositoty buildingRepositoty;

	@Override
	public List<BuildingDTO> findAll(String name, Long districtId) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = buildingRepositoty.findAll(name, districtId);
		List<BuildingDTO> resultBuildingDTOs = new ArrayList<BuildingDTO>();
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			buildingDTO.setAddress(item.getStreet() + "," + item.getWard());
			buildingDTO.setNumberOfBasement(item.getNumberOfBasement());
			resultBuildingDTOs.add(buildingDTO);
		}
		return resultBuildingDTOs;
	}

}
