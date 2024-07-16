package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;

	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String,Object> params,
										@RequestParam(name ="typeCode", required = false) List<String> typeCode) {
		List<BuildingDTO> result = buildingService.findAll(params, typeCode);
		return result;
	}

//	@PostMapping(value = "/api/building/")
//	public List<BuildingDTO> getBuilding2(@RequestBody BuildingDTO buildingDTO) {
//
//		return resultBuildingDTOs;
//	}

//	public void validField(BuildingDTO buildingDTO) {
//		if (buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumberOfBasement() == null) {
//			throw new FieldRequiredException("Name or NoB is null");
//		}
//			
//	}
//
//	@DeleteMapping(value = "/api/building/{id}")
//	public void deleteBuilding2(@PathVariable Integer id) {
//		System.out.print("very nice " + id);
//	}
}
