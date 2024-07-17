package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

// attributes name must map name fields in DB (exam: WHERE b.districtId = 1) 
public class BuildingSearchBuilder {
	private Long id;
	private String name;
	private String ward;
	private String street;
	private Long districtId;
	private Integer numberOfBasement;
	private List<String> typeCode = new ArrayList<String>();
	private String managerName;
	private String managerPhoneNumber;
	private Long floorArea;
	private Long rentAreaFrom;
	private Long rentAreaTo;
	private String emptyArea;
	private Long rentPrice;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private Long serviceFee;
	private Long brokerageFee;
	private Long staffId;

	public BuildingSearchBuilder(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.ward = builder.ward;
		this.street = builder.street;
		this.districtId = builder.districtId;
		this.numberOfBasement = builder.numberOfBasement;
		this.typeCode = builder.typeCode;
		this.managerName = builder.managerName;
		this.managerPhoneNumber = builder.managerPhoneNumber;
		this.floorArea = builder.floorArea;
		this.rentAreaFrom = builder.rentAreaFrom;
		this.rentAreaTo = builder.rentAreaTo;
		this.emptyArea = builder.emptyArea;
		this.rentPrice = builder.rentPrice;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.serviceFee = builder.serviceFee;
		this.brokerageFee = builder.brokerageFee;
		this.staffId = builder.staffId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public List<String> getTypeCode() {
		return typeCode;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public String getEmptyArea() {
		return emptyArea;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public Long getServiceFee() {
		return serviceFee;
	}

	public Long getBrokerageFee() {
		return brokerageFee;
	}

	public Long getStaffId() {
		return staffId;
	}

	public Long getRentAreaFrom() {
		return rentAreaFrom;
	}

	public Long getRentAreaTo() {
		return rentAreaTo;
	}

	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}

	public Long getRentPriceTo() {
		return rentPriceTo;
	}

	public static class Builder {
		private Long id;
		private String name;
		private String ward;
		private String street;
		private Long districtId;
		private Integer numberOfBasement;
		private List<String> typeCode = new ArrayList<String>();
		private String managerName;
		private String managerPhoneNumber;
		private Long floorArea;
		private Long rentAreaFrom;
		private Long rentAreaTo;
		private String emptyArea;
		private Long rentPrice;
		private Long rentPriceFrom;
		private Long rentPriceTo;
		private Long serviceFee;
		private Long brokerageFee;
		private Long staffId;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}

		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}

		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}

		public Builder setManagerPhoneNumber(String managerPhoneNumber) {
			this.managerPhoneNumber = managerPhoneNumber;
			return this;
		}

		public Builder setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
			return this;
		}

		public Builder setEmptyArea(String emptyArea) {
			this.emptyArea = emptyArea;
			return this;
		}

		public Builder setRentPrice(Long rentPrice) {
			this.rentPrice = rentPrice;
			return this;
		}

		public Builder setServiceFee(Long serviceFee) {
			this.serviceFee = serviceFee;
			return this;
		}

		public Builder setBrokerageFee(Long brokerageFee) {
			this.brokerageFee = brokerageFee;
			return this;
		}

		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		
		public Builder setRentAreaFrom(Long rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}

		public Builder setRentAreaTo(Long rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}

		public Builder setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}

		public Builder setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}

	}

}
