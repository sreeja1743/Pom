package com.ec.onlineplantnursery.requestDto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlantRequestDto {

	@ApiModelProperty(name="Plant ID",required=true)
	private Integer plantId;
	
	@Positive(message = "Height of plant should be positive")
	private Integer plantHeight;
	
	@NotEmpty(message="Plant spread cannot be blank")
	@Size(min=3, max=15, message="Invalid Plant spread")
	private String plantSpread;
	
	
	@Column(unique = true)
	@NotEmpty(message="Plant Name cannot be blank")
	@Size(min=3, max=15, message="Invalid Plant Name")
	private String commonName;
	
	@ApiModelProperty(name = "Bloom Time",value = "Hold the min 3 char bloom time",required = true)
	@NotEmpty(message = "bloom time cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid bloom time, bloom time should have minimum 3 and maximum 15 characters")
	private String bloomTime;
	
	
	private String medicinalOrCulinaryUse;
	
	@ApiModelProperty(name = "Difficulty Level",value = "Should not be null",required = true)
	@NotEmpty(message = "difficulty level cannot be left blank or null")
	private String difficultyLevel;
	
	@ApiModelProperty(name = "Temperature",value = "Should not be null",required = true)
	@NotEmpty(message = "Temperature cannot be left blank or null")
	private String temparature;
	
	@NotNull
	//@Size(min=3, max=15, message="Invalid Plant type")
	private String typeOfPlant;
	
	@ApiModelProperty(name = "Plant Description",value = "Should not be null",required = true)
	@NotEmpty(message = "plant description cannot be left blank or null")
	private String plantDescription;
	
	@ApiModelProperty(name = "PlantStock",value = "Holds only positive value")
	@Positive(message = "Stock should be positive")
	private Integer plantsStock;
	
	@Positive(message = "Enter valid cost")
	private double plantCost;
	
	
	
	
	public Integer getPlantId() {
		return plantId;
	}
	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}
	public Integer getPlantHeight() {
		return plantHeight;
	}
	public void setPlantHeight(Integer plantHeight) {
		this.plantHeight = plantHeight;
	}
	public String getPlantSpread() {
		return plantSpread;
	}
	public void setPlantSpread(String plantSpread) {
		this.plantSpread = plantSpread;
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
	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}
	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
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
	public String getTypeOfPlant() {
		return typeOfPlant;
	}
	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}
	public String getPlantDescription() {
		return plantDescription;
	}
	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}
	public Integer getPlantsStock() {
		return plantsStock;
	}
	public void setPlantsStock(Integer plantsStock) {
		this.plantsStock = plantsStock;
	}
	public double getPlantCost() {
		return plantCost;
	}
	public void setPlantCost(double plantCost) {
		this.plantCost = plantCost;
	}
	
	
	
}
