package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO buildingDTO = modelMapper.map(item, BuildingDTO.class);
		buildingDTO.setAddress(item.getStreet() + ", " + item.getWard() + ", " + item.getDistrict().getName());
		List<RentAreaEntity> rentAreas = item.getRentarea();
		String rentAreaString = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		buildingDTO.setRentArea(rentAreaString);
		return buildingDTO;
	}
}
