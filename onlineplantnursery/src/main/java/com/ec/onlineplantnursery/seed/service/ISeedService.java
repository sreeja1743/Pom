package com.ec.onlineplantnursery.seed.service;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.seed.entity.Seed;

public interface ISeedService {
	Seed addSeed(Seed seed);

	Seed updateSeed(Seed seed) throws SeedIdNotFoundException;

	Seed deleteSeed(Seed seed) throws SeedIdNotFoundException;

	Seed viewSeed(int seedId) throws SeedIdNotFoundException;

	Seed viewSeed(String commonName) throws ResourceNotFoundException;

	List<Seed> viewAllSeeds();

	List<Seed> viewAllSeeds(String typeOfSeed) throws ResourceNotFoundException;
}
