package com.ec.onlineplantnursery.service;

import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.repository.IPlantRepository;
import com.ec.onlineplantnursery.plant.service.IPlantService;
import com.ec.onlineplantnursery.plant.service.IPlantServiceImpl;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepository;
import com.ec.onlineplantnursery.planter.service.IPlanterServiceImpl;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.ISeedRepository;
import com.ec.onlineplantnursery.seed.service.ISeedService;
import com.ec.onlineplantnursery.seed.service.ISeedServiceImpl;

@SpringBootTest
public class PlanterServiceImplTest {

	IPlanterRepository planterRepo;
	IPlantRepository plantRepo;
	ISeedRepository seedRepo;
	private static IPlanterServiceImpl planterService;
	private static IPlantServiceImpl plantService;
	private static ISeedServiceImpl seedService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit()
	{
		planterRepo = mock(IPlanterRepository.class); // test through approach 2
		planterService = new  IPlanterServiceImpl(planterRepo); 	// Approach 2
		plantRepo = mock(IPlantRepository.class);
		plantService = new IPlantServiceImpl(plantRepo);
		seedRepo = mock(ISeedRepository.class);
		seedService = new ISeedServiceImpl(seedRepo);
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}

	@Test
	@DisplayName("Test-Get All Planters , Args:- No Args to pass")
	void testGetAllPlanters() {


		List<Planter> pList = mock(List.class); 
		when(planterRepo.findAll()).thenReturn(pList);
		planterService.viewAllPlanters();
		verify(planterRepo).findAll();

	}

	@Test
	@DisplayName("Test-Get Planter by Id , Args:- No Args to pass")
	void testExceptionViewPlanterById() throws ResourceNotFoundException{


		Optional<Planter> s = Optional.empty();
		when(planterRepo.findById(2)).thenReturn(s);
		Executable executable = ()->planterService.viewPlanter(2);
		assertThrows(ResourceNotFoundException.class, executable);

	}
	
	@Test
	void testViewPlanterById() throws ResourceNotFoundException {
		Seed sinput = new Seed("Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		sinput.setSeedId(1);
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,null,sinput);
		when(planterRepo.findById(1)).thenReturn(Optional.of(input));
		Planter testPlanter = planterService.viewPlanter(input.getPlanterId());
		assertEquals(input, testPlanter);

		
		
	}

	@Test
	@DisplayName("Test-Get Planter by Planter Shape , Args:- No Args to pass")
	void testViewPlanterByShape() throws ResourceNotFoundException {


		String planterShape = "square";
		List<Planter> s = null;
		when(planterRepo.viewPlanter(planterShape)).thenReturn(s);
		Executable executable = ()->planterService.viewPlanter(planterShape);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	@Test
	@DisplayName("Test-Get Planter by range , Args:- No Args to pass")
	void testViewPlanterByRange() throws ResourceNotFoundException {


		double minCost = 50;
		double maxCost = 100;
		List<Planter> pList = null;
		when(planterRepo.getPlantersByRange(minCost,maxCost)).thenReturn(pList);
		//call the actual method 
		Executable executable = ()->planterService.viewAllPlanters(minCost,maxCost);
		assertThrows(ResourceNotFoundException.class, executable);

	}

	
	@Test
	@DisplayName("Test-Delete Planter , Args:- No Args to pass")
	void testDeletePlanter() throws ResourceNotFoundException {

		Seed sinput = new Seed("Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		sinput.setSeedId(1);
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,null,sinput);
		
		when(planterRepo.findById(input.getPlanterId())).thenReturn(Optional.of(input));
		Planter testPlanter = planterService.deletePlanter(input);
		assertEquals(input,testPlanter);
		
		planterService.deletePlanter(input);
		
	}


	@Test
	@DisplayName("Test-Update Planter , Args:- No Args to pass")
	void testUpdatePlanter() throws ResourceNotFoundException {
		Seed sinput = new Seed("Mango","Morning", "Twice a day", "easy","25ºC","Monocotyledonous",
				"This seed is a small embryonic plant",250,300,2000);
		sinput.setSeedId(1);
		Planter input = new Planter(1,12,3,2,23,"Round",45,30,null,sinput);
		Planter savedPlanter = new Planter(1,12,3,2,23,"Square",45,30,null,sinput);

		
		when(planterRepo.findById(1)).thenReturn(Optional.of(input));
		
		when(planterRepo.save(savedPlanter)).thenReturn(savedPlanter);
		Planter testPlanter =   planterService.updatePlanter(savedPlanter);
		assertEquals(savedPlanter, testPlanter);

	}

}