package com.ec.onlineplantnursery.planter.repository;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.planter.entity.Planter;

public interface CustomPlanterRepository {

	List<Planter> viewPlanter(String planterShape);
	List<Planter> getPlantersByRange(double minCost, double maxCost);
}
