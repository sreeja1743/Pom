package com.ec.onlineplantnursery.planter.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepository;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;


@Service
public class IPlanterServiceImpl implements IPlanterService
{

	@Autowired
	private IPlanterRepository planterRepo;
	
	@Autowired
	IPlantRepository plantRepo;
	
	@Autowired
	ISeedRepository seedRepo;
	
	
	

	public IPlanterServiceImpl() {
		super();
	}
	
	
	

	public IPlanterServiceImpl(ISeedRepository seedRepo) {
		super();
		this.seedRepo = seedRepo;
	}




	public IPlanterServiceImpl(IPlantRepository plantRepo) {
		super();
		this.plantRepo = plantRepo;
	}




	public IPlanterServiceImpl(IPlanterRepository planterRepo) {
		super();
		this.planterRepo = planterRepo;
	}


	
	/*Method Name:addPlanter
	 *Parameters:Planter
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 23/05/2021 */

	@Override
	public Planter addPlanter(Planter planter) throws ResourceNotFoundException {
		
		Optional<Seed> s = Optional.empty();
		Optional<Plant> p = Optional.empty();
		if(planter.getSeed() != null) {
			s = seedRepo.findById(planter.getSeed().getSeedId());
		}
		if(planter.getPlant() != null) {
			 p = plantRepo.findById(planter.getPlant().getPlantId());
		}
		if(p.isPresent() || s.isPresent()) {
			return planterRepo.save(planter);
		}
		else {
			throw new ResourceNotFoundException();
		}
		
	}
	
	/*Method Name:updatePlanter
	 *Parameters:Planter
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 24/05/2021 */

	@Override
	public Planter updatePlanter(Planter planter) throws ResourceNotFoundException{
		Optional<Planter> pl = planterRepo.findById(planter.getPlanterId());
		if(pl.isPresent()) {
			
			return planterRepo.save(planter);
		}
		throw new ResourceNotFoundException();
	}

	
	/*Method Name:deletePlanter
	 *Parameters:planterId
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 24/05/2021 */
	
	
	/*Method Name:deletePlanter
	 *Parameters:planter
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 24/05/2021 */
	
	
	@Override
	public Planter deletePlanter(Planter planter) throws ResourceNotFoundException{
		Optional<Planter> pl = planterRepo.findById(planter.getPlanterId());
		if(!(pl.isPresent())) {
			throw new ResourceNotFoundException("No Planter found with the Id");
		}
		
		planterRepo.delete(planter);
		return pl.get();
	}
	
	/*Method Name:viewPlanter
	 *Parameters:planterId
	 *ReturnType:Planter
	 *Author Name:Tripura
	 *Created Date: 23/05/2021 */

	@Override
	@Transactional
	public Planter viewPlanter(int planterId) throws ResourceNotFoundException {
		Optional<Planter> pl = planterRepo.findById(planterId);
		if(pl.isPresent()) {
			return pl.get();
			
		}
		else {
			throw new ResourceNotFoundException("No Planter found with the Id");
		}
	}

	/*Method Name:viewPlanter
	 *Parameters:planterShape
	 *ReturnType:List<Planter>
	 *Author Name:Tripura
	 *Created Date: 25/05/2021 */
	
	@Override
	public List<Planter> viewPlanter(String planterShape) throws ResourceNotFoundException{
		List<Planter> plist = planterRepo.viewPlanter(planterShape);
		if(plist != null) {
			return plist;
		}
		throw new ResourceNotFoundException();
	}

	
	/*Method Name:viewAllPlanters
	 *Parameters:No parameters
	 *ReturnType:List<Planter>
	 *Author Name:Tripura
	 *Created Date: 23/05/2021 */
	
	@Override
	public List<Planter> viewAllPlanters() {
		
		return planterRepo.findAll();
	}

	
	
	/*Method Name:viewAllPlanters
	 *Parameters:minCost,maxCost
	 *ReturnType:List<Planter>
	 *Author Name:Tripura
	 *Created Date: 24/05/2021 */
	
	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost)throws ResourceNotFoundException {
			List<Planter> planter = planterRepo.getPlantersByRange(minCost, maxCost);
			if(planter != null) {
				return planter;
				
			}
			else {
				throw new ResourceNotFoundException();
			}
		}
		
	}

