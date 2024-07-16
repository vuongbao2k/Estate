package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO buildingDTO = modelMapper.map(item, BuildingDTO.class);
//		buildingDTO.setName(item.getName());
//		buildingDTO.setManagerName(item.getManagerName());
//		buildingDTO.setManagerPhoneNumber(item.getManagerPhoneNumber());
//		buildingDTO.setFloorArea(item.getFloorArea());
//		buildingDTO.setEmptyArea(item.getEmptyArea());
//		buildingDTO.setRentPrice(item.getRentPrice());
//		buildingDTO.setServiceFee(item.getServiceFee());
//		buildingDTO.setBrokerageFee(item.getBrokerageFee());
		DistrictEntity districtEntity = districtRepository.findNameByID(item.getDistrictId());
		buildingDTO.setAddress(item.getStreet() + ", " + item.getWard() + ", " + districtEntity.getName());
		List<RentAreaEntity> rentAreas = rentAreaRepository.getValueByBuildingId(item.getId());
		String rentAreaString = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		buildingDTO.setRentArea(rentAreaString);
		return buildingDTO;
	}
}
