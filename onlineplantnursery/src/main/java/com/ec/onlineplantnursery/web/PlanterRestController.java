package com.ec.onlineplantnursery.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.service.IPlanterService;
import com.ec.onlineplantnursery.requestDto.PlanterRequestDto;
import com.ec.onlineplantnursery.responseDto.PlantResponseDto;
import com.ec.onlineplantnursery.responseDto.PlanterResponseDto;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api/planter")
@Api(value = "Online Nursery Store",description = "Various api works on laptop inventory management")

public class PlanterRestController {

	Logger log = org.slf4j.LoggerFactory.getLogger(PlanterRestController.class);
		
		@Autowired
		IPlanterService planterService;
		
		@Autowired
		private ModelMapper modelMapper;
		
		
		
		/*Method Name:insertPlanter
		 *Parameters:Planter
		 *ReturnType:Planter
		 *Author Name:Tripura
		 *Created Date: 23/05/2021 */
		
		@ApiOperation(value = "planter post mapping. Give plantId and seedId as zero in url if creating new plant and seed instance through planter." , response = Planter.class)
		@PostMapping("/planter/insert")
		public ResponseEntity<PlanterResponseDto> insertPlanter(@RequestBody @Valid PlanterRequestDto planter) throws ResourceNotFoundException {
			log.info("inside insert planter");
			Planter planter1 = modelMapper.map(planter, Planter.class);
			Planter planter2 = planterService.addPlanter(planter1);
			PlanterResponseDto planteResponse = modelMapper.map(planter2, PlanterResponseDto.class);
			return new ResponseEntity<>(planteResponse, HttpStatus.CREATED);
		}
		
		
		/*Method Name:updatePlanter
		 *Parameters:Planter
		 *ReturnType:Planter
		 *Author Name:Tripura
		 *Created Date: 24/05/2021 */
		
		@PutMapping("planter/update")
		public ResponseEntity<PlanterResponseDto> updatePlanter(@RequestBody PlanterRequestDto planterDto) throws ResourceNotFoundException{
			Planter planter = modelMapper.map(planterDto, Planter.class);
			Planter updatedPlanter = planterService.updatePlanter(planter);
			PlanterResponseDto responsePlanter = modelMapper.map(updatedPlanter, PlanterResponseDto.class);
			return new ResponseEntity<>(responsePlanter, HttpStatus.OK);
		}

		
		/*Method Name:deletePlanter
		 *Parameters:planterId
		 *ReturnType:Planter
		 *Author Name:Tripura
		 *Created Date: 24/05/2021 */
		
		@ApiOperation(value = "planter delete mapping to delete planter" , response = Planter.class)
		@DeleteMapping("/planter/delete")
		public ResponseEntity<PlanterResponseDto> deletePlanter(@RequestBody PlanterRequestDto planterDto) throws ResourceNotFoundException//through id
		{
			log.info("inside delete planter by id");
			Planter planter = modelMapper.map(planterDto, Planter.class);
			Planter deletePlanter = planterService.deletePlanter(planter);
			PlanterResponseDto deletedPlanter = modelMapper.map(deletePlanter, PlanterResponseDto.class);
			return new ResponseEntity<>(deletedPlanter, HttpStatus.OK);
		}

		
		
		
		/*Method Name:viewPlanter
		 *Parameters:Planter
		 *ReturnType:Planter
		 *Author Name:Tripura
		 *Created Date: 23/05/2021 */
		@ApiOperation(value = "planter get mapping to view planter by id" , response = Planter.class)
		@GetMapping("/planter/view/{planterId}")
		public ResponseEntity<PlanterResponseDto> viewPlanter(@PathVariable int planterId) throws ResourceNotFoundException
		{
			log.info("inside Get planter by planter id");
			Planter planter = planterService.viewPlanter(planterId);
			PlanterResponseDto planterResponse = modelMapper.map(planter, PlanterResponseDto.class);
			
			return new ResponseEntity<>(planterResponse, HttpStatus.OK);
		}


		
		/*Method Name:viewAllPlanters
		 *Parameters:No parameters
		 *ReturnType:List<Planter>
		 *Author Name:Tripura
		 *Created Date: 23/05/2021 */
		@ApiOperation(value = "Planter Get mapping to fetch all planters" , response = List.class)
		@GetMapping("/planters/all")
		public List<PlanterResponseDto> viewAllPlanters() throws ResourceNotFoundException{
			
			log.info("inside Get all planters informatio");
			return planterService.viewAllPlanters().stream().map(planter->modelMapper.map(planter, PlanterResponseDto.class)).collect(Collectors.toList());
			
		}

		/*Method Name:updatePlanter
		 *Parameters:minCost, maxCost
		 *ReturnType:List<Planter>
		 *Author Name:Tripura
		 *Created Date: 24/05/2021 */
		@ApiOperation(value = "planter get mapping to view all planter whose cost is between the given range" , response = Planter.class)
		@GetMapping("/planters/cost/range/{minCost}/{maxCost}")
		public List<PlanterResponseDto> viewAllPlanters(@PathVariable double minCost, @PathVariable double maxCost) throws ResourceNotFoundException{ 
			
			log.info("inside Get all planters  whose cost is between the given range");

			return planterService.viewAllPlanters(minCost, maxCost).stream().map(planter->modelMapper.map(planter, PlanterResponseDto.class)).collect(Collectors.toList());
			
		}
		
		
		/*Method Name:viewPlanter
		 *Parameters:plantershape
		 *ReturnType:List<Planter>
		 *Author Name:Tripura
		 *Created Date: 25/05/2021 */
		@ApiOperation(value = "planter get mapping to view planters by shape" , response = Planter.class)
		@GetMapping("/planters/Shape/{planterShape}")
		public List<PlanterResponseDto> viewPlanter(@PathVariable String planterShape) throws ResourceNotFoundException{ 
			
			log.info("inside Get all planters by planter shape");
			
			return planterService.viewPlanter(planterShape).stream().map(planter->modelMapper.map(planter, PlanterResponseDto.class)).collect(Collectors.toList());
			
		}

}
