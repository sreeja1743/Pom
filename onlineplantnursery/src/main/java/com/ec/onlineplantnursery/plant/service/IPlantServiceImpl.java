package com.ec.onlineplantnursery.plant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ec.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.seed.entity.Seed;



@Service
public class IPlantServiceImpl implements IPlantService{

	@Autowired
	IPlantRepository plantRepo;
	
	
	
	public IPlantServiceImpl() {
		super();
		
	}

	

	public IPlantServiceImpl(IPlantRepository plantRepo) {
		super();
		this.plantRepo = plantRepo;
	}

	/*Method Name:addPlant
	 *Parameters:Plant
	 *ReturnType:Plant
	 *Author Name:Ambidi Swathi
	 *Created Date: 22/05/2021 */


	@Override
	@Transactional
	public Plant addPlant(Plant plant) {
		
		plantRepo.save(plant);
		return plant;

	}
	
	
	/*Method Name:updatePlant
	 *Parameters:Plant
	 *ReturnType:Plant
	 *Author Name:Ambidi Swathi
	 *Created Date: 22/05/2021 */
	
	@Override
	public Plant updatePlant(Plant plant) throws PlantIdNotFoundException{
		Optional<Plant> existingPlant = plantRepo.findById(plant.getPlantId());
        if(existingPlant.isPresent()) {
       
    		return plantRepo.save(plant);
        }
        else {
        	throw new PlantIdNotFoundException(plant.getPlantId());
        }
		
		
	}
	
	/*Method Name:deletePlant
	 *Parameters:Plant
	 *ReturnType:Plant
	 *Author Name:Ambidi Swathi
	 *Created Date: 25/05/2021 */

	@Override
	public Plant deletePlant(Plant plant) throws PlantIdNotFoundException{
		Optional<Plant> plant1 = plantRepo.findById(plant.getPlantId());
		if(plant1.isPresent()) {
			plantRepo.delete(plant);	
		}
		else {
			throw new PlantIdNotFoundException(plant.getPlantId());
		}
		
		return plant1.get();
	}

	
	/*Method Name:viewPlant
	 *Parameters:PlantId
	 *ReturnType:Plant
	 *Author Name:Ambidi Swathi
	 *Created Date: 23/05/2021 */
	
	@Override
	public Plant viewPlant(int plantId) throws PlantIdNotFoundException{
		
		Optional<Plant> plant = plantRepo.findById(plantId);
		if(plant.isPresent()) {
			return plant.get();
			
		}
		else {
			throw new PlantIdNotFoundException(plantId);
		}
		
	}
	
	
	/*Method Name:viewPlant
	 *Parameters:commonName
	 *ReturnType:Optional<Plant>
	 *Author Name:Ambidi Swathi
	 *Created Date: 24/05/2021 */

	@Override
	public Plant viewPlant(String commonName) throws ResourceNotFoundException {
		Plant plant = plantRepo.viewPlant(commonName);
		
		if(plant != null) 
			return plant;
		else {
			throw new ResourceNotFoundException(commonName);
		}

		
		
	}
	
	
	/*Method Name:viewAllPlants
	 *Parameters: No Parameters
	 *ReturnType:List<Plant>
	 *Author Name:Ambidi Swathi
	 *Created Date: 24/05/2021 */

	@Override
	public List<Plant> viewAllPlants() {
		
		return plantRepo.findAll();
	}

	
	
	/*Method Name:viewAllPlants
	 *Parameters:typeOfPlant
	 *ReturnType:Optional<List<Plant>>
	 *Author Name:Ambidi Swathi
	 *Created Date: 24/05/2021 */
	
	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) throws ResourceNotFoundException {
		
		List<Plant> plants = plantRepo.viewAllPlants(typeOfPlant);
		if(plants != null) {
		return plants;

		}
		else {
			throw new ResourceNotFoundException();
		}
	}




}
