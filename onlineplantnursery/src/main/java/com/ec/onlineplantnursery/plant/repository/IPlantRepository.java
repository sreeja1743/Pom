package com.ec.onlineplantnursery.plant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.onlineplantnursery.plant.entity.Plant;

public interface IPlantRepository extends JpaRepository<Plant, Integer>,CustomPlantRepository{
	
}
