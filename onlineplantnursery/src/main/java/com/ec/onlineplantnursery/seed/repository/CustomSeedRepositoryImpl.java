package com.ec.onlineplantnursery.seed.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.seed.entity.Seed;

public class CustomSeedRepositoryImpl implements CustomSeedRepository{
	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public Seed getSeedByCommonName(String commonName)  {
			
		Query q = entityManager.createQuery("from Seed where commonName=:commonName");
		q.setParameter("commonName", commonName);
		return (Seed) q.getSingleResult();
	}

	
	@Override
	public List<Seed> getSeedsByTypeOfSeed(String typeOfSeed) {
		
		Query q = entityManager.createQuery("from Seed where typeOfSeeds=:typeOfSeed");
		q.setParameter("typeOfSeed", typeOfSeed);
		return q.getResultList();
		
	}
}

