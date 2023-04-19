package com.api_rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.api_rest.model.Building;
import com.api_rest.service.BuildingServices;


@Controller
@RequestMapping("/E3W2U2/buildings")
public class BuildingController {

	@Autowired BuildingServices buildingService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBuilding(@PathVariable Long id) {
		return new ResponseEntity<Building>(buildingService.findById(id), HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBuildings() {
		return new ResponseEntity<List<Building>>(buildingService.findAllBuilding(), HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> postNewBuilding(@RequestBody Building building) {
		return new ResponseEntity<String>(buildingService.persistBuilding(building), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putBuilding(@RequestBody Building building) {
		return new ResponseEntity<String>(buildingService.updateBuilding(building), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteBuilding(@RequestBody Building building) {
		return new ResponseEntity<String>(buildingService.removeBuilding(building), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBuildingById(@PathVariable Long id) {
		return new ResponseEntity<String>(buildingService.removeBuilding(id), HttpStatus.OK);
	}
	
}
