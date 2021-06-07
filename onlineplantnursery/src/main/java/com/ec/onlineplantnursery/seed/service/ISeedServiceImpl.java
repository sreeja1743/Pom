package com.ec.onlineplantnursery.seed.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;

@Service
public class ISeedServiceImpl implements ISeedService{
	
	@Autowired
	ISeedRepository seedRepo;
	

	public ISeedServiceImpl(ISeedRepository seedRepo) {
		super();
		this.seedRepo = seedRepo;
	}
	
	
	
	/*Method Name:addSeed
	 *Parameters:Seed
	 *ReturnType:Seed
	 *Author Name:Nagolu Tejashwini
	 *Created Date: 21/05/2021 */
	
	@Override
	@Transactional
	public Seed addSeed(Seed seed) {
		
		seedRepo.save(seed);
		return seed;
	}
	
	
	/*Method Name:updateSeed
	 *Parameters:Seed
	 *ReturnType:Seed
	 *Author Name:Nagolu Tejashwini
	 *Created Date: 24/05/2021 */
	
	
	@Override
	public Seed updateSeed(Seed seed) throws SeedIdNotFoundException {
		
		Optional<Seed> seed1 = seedRepo.findById(seed.getSeedId());

		if(seed1.isPresent()) {
			return seedRepo.save(seed);
			
		}
		else {
			throw new SeedIdNotFoundException(seed.getSeedId());
			
		}
		
		
		
	}

	
	/*Method Name:deleteSeed
	 *Parameters:Seed
	 *ReturnType:Seed
	 *Author Name:Nagolu Tejashwini
	 *Created Date: 24/05/2021 */
	
	@Override
	@Transactional
	public Seed deleteSeed(Seed input) throws SeedIdNotFoundException {
		
		Optional<Seed> s = seedRepo.findById(input.getSeedId());
		if(s.isPresent()) {
			seedRepo.delete(input);
			return s.get();
		}
		else {
			throw new SeedIdNotFoundException(input.getSeedId());
		}
		
	}

	
	/*Method Name:viewSeed
	 *Parameters:seedId
	 *ReturnType:Seed
	 *Author Name:Nagolu Tejashwini
	 *Created Date: 21/05/2021 */
	
	@Override
	public Seed viewSeed(int seedId) throws SeedIdNotFoundException  {
		Optional<Seed> s = seedRepo.findById(seedId);
		if(s.isPresent()) {
			return s.get();
			
		}
		else {
			throw new SeedIdNotFoundException(seedId);
		}
		
	}

	/*Method Name:viewSeed
	 *Parameters:commonName
	 *Author Name:Nagolu Tejashwini
	 *ReturnType:Optional<Seed>
	 *Created Date: 24/05/2021 */
	
	@Override
	public Seed viewSeed(String commonName) throws ResourceNotFoundException {
		Seed s1 = seedRepo.getSeedByCommonName(commonName);
		
		if(s1 != null)  {

		return s1;
		}
		else {
			throw new ResourceNotFoundException(commonName);
		}
	}
	
	/*Method Name:viewAllSeeds
	 *Parameters:No Parameters
	 *ReturnType:Optional<List<Seed>>
	 *Author Name:Nagolu Tejashwini
	 *Created Date: 21/05/2021 */

	@Override
	public List<Seed> viewAllSeeds() {
		
		return seedRepo.findAll();
	}

	
	/*Method Name:viewAllSeeds
	 *Parameters:Seed
	 *ReturnType:Seed
	 *Author Name:Nagolu Tejashwini
	 *Created Date: 24/05/2021 */
	
	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws ResourceNotFoundException {
		List<Seed> sList = seedRepo.getSeedsByTypeOfSeed(typeOfSeed);
		if(Optional.of(sList).isPresent()) {
			return sList;
			
		}
		else {
			throw new ResourceNotFoundException(typeOfSeed);
		}
		
	}
}
