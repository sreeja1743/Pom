package com.ec.onlineplantnursery.requestDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.seed.entity.Seed;

import lombok.Data;

@Data
public class PlanterRequestDto {

	
	
	private Integer planterId;
	
	@Positive(message = "Should be positive")
	private float planterheight;
	
	@Min(value = 1, message = "Capacity cannot be less than 1")
	private int planterCapacity;
	
	@Positive(message = "Should be positive")
	private int drinageHoles;
	
	@Positive(message = "Should be positive")
	private int planterColor;
	
	@NotEmpty(message = "Planter shape cannot be left blank or null")
	@Size(min = 3,max = 15, message = "Invalid Planter shape")
	private String planterShape;
	
	@Min(value = 1, message = "In stock cannot be less than 1")
	private int planterStock;
	
	@Min(value = 50, message = "Cost cannot be less than 50")
	private int planterCost;
	
	private Plant plant;
	
	private Seed seed;
	
	public Integer getPlanterId() {
		return planterId;
	}
	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}
	public float getPlanterheight() {
		return planterheight;
	}
	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
	}
	public int getPlanterCapacity() {
		return planterCapacity;
	}
	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}
	public int getDrinageHoles() {
		return drinageHoles;
	}
	public void setDrinageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
	}
	public int getPlanterColor() {
		return planterColor;
	}
	public void setPlanterColor(int planterColor) {
		this.planterColor = planterColor;
	}
	public String getPlanterShape() {
		return planterShape;
	}
	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}
	public int getPlanterStock() {
		return planterStock;
	}
	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}
	public int getPlanterCost() {
		return planterCost;
	}
	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public Seed getSeed() {
		return seed;
	}
	public void setSeed(Seed seed) {
		this.seed = seed;
	}
	
	
	
	
}
