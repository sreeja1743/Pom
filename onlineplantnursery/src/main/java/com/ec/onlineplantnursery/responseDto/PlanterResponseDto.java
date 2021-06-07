package com.ec.onlineplantnursery.responseDto;

import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.seed.entity.Seed;

public class PlanterResponseDto {

	private Integer planterId;
	private float planterheight;
	private int planterCapacity;
	private int drinageHoles;
	private int planterColor;
	private String planterShape;
	private int planterStock;
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
