package com.ec.onlineplantnursery.plant.service;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;

public interface IPlantService {
	Plant addPlant(Plant plant);

	Plant updatePlant(Plant plant) throws PlantIdNotFoundException;

	Plant deletePlant(Plant plant) throws PlantIdNotFoundException;

	Plant viewPlant(int plantId) throws PlantIdNotFoundException ;

	Plant viewPlant(String commonName) throws ResourceNotFoundException;

	List<Plant> viewAllPlants();

	List<Plant> viewAllPlants(String typeOfPlant) throws ResourceNotFoundException;
}
