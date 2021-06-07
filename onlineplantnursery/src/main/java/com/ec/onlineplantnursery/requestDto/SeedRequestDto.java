package com.ec.onlineplantnursery.requestDto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SeedRequestDto {
	
	private Integer seedId;
	
	@ApiModelProperty(name = "SeedName",value = "Hold the min 3 char seed name",required = true)
	@NotEmpty(message = "Seed Name cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid Seed Name, Seed Name should have minimum 3 and maximum 15 characters")
	@Column(unique = true)
	private String commonName;
	
	@ApiModelProperty(name = "Bloom Time",value = "Hold the min 3 char bloom time",required = true)
	@NotEmpty(message = "bloom time cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid bloom time, bloom time should have minimum 3 and maximum 15 characters")
	private String bloomTime;
	
	@ApiModelProperty(name = "Watering",value = "Should not be null",required = true)
	@NotEmpty(message = "watering cannot be left blank or null")
	private String watering;
	
	@ApiModelProperty(name = "Difficulty Level",value = "Should not be null",required = true)
	@NotEmpty(message = "difficulty level cannot be left blank or null")
	private String difficultyLevel;
	
	@ApiModelProperty(name = "Temperature",value = "Should not be null",required = true)
	@NotEmpty(message = "Temperature cannot be left blank or null")
	private String temparature;
	
	@ApiModelProperty(name = "Type of Seeds",value = "Should not be null",required = true)
	@NotEmpty(message = "Type of seeds cannot be left blank or null")
	private String typeOfSeeds;
	
	@ApiModelProperty(name = "Seeds Description",value = "Should not be null",required = true)
	@NotEmpty(message = "seeds description cannot be left blank or null")
	private String seedsDescription;
	
	@ApiModelProperty(name = "SeedStock",value = "Holds only positive value")
	@Positive(message = "Stock should be positive")
	private Integer seedsStock;
	
	@ApiModelProperty(name = "SeedCost",value = "Holds only positive value")
	@Positive(message = "Cost should be positive")
	private double seedsCost;
	
	@ApiModelProperty(name = "SeedsPerPacket",value = "Holds only positive value")
	@Positive(message = "SeedsPerPacket should be positive")
	private Integer seedsPerPacket;
	
	
	
	public SeedRequestDto() {
		super();
		
	}
	
	
	public SeedRequestDto(Integer seedId, String commonName, String bloomTime, String watering, String difficultyLevel,
			String temparature, String typeOfSeeds, String seedsDescription, Integer seedsStock, double seedsCost,
			Integer seedsPerPacket) {
		super();
		this.seedId = seedId;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.seedsCost = seedsCost;
		this.seedsPerPacket = seedsPerPacket;
	}
	
	
	public Integer getSeedId() {
		return seedId;
	}
	public void setSeedId(Integer seedId) {
		this.seedId = seedId;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}
	public String getWatering() {
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getTemparature() {
		return temparature;
	}
	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}
	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}
	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}
	public String getSeedsDescription() {
		return seedsDescription;
	}
	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}
	public Integer getSeedsStock() {
		return seedsStock;
	}
	public void setSeedsStock(Integer seedsStock) {
		this.seedsStock = seedsStock;
	}
	public double getSeedsCost() {
		return seedsCost;
	}
	public void setSeedsCost(double seedsCost) {
		this.seedsCost = seedsCost;
	}
	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}
	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}
	
	
	

	

	

}
