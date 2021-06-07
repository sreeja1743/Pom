package com.ec.onlineplantnursery.plant.repository;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.plant.entity.Plant;

public interface CustomPlantRepository {
	Plant viewPlant(String commonName);
	List<Plant> viewAllPlants(String typeOfPlant);

}
