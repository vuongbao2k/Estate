package com.javaweb.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name = "buildingid")
//	private Long buildingId;
	
	@Column(name = "value")
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "buildingid")
	private BuildingEntity building;
	

	public BuildingEntity getBuilding() {
		return building;
	}

	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getBuildingId() {
//		return buildingId;
//	}
//
//	public void setBuildingId(Long buildingId) {
//		this.buildingId = buildingId;
//	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
