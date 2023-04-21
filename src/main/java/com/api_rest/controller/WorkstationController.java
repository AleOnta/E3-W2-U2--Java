package com.api_rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.api_rest.model.Workstation;
import com.api_rest.service.WorkstationServices;

@Controller
@RequestMapping("/E3W2U2/workstations")
public class WorkstationController {
	
	@Autowired WorkstationServices worksService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getWorkstation(@PathVariable Long id) {
		return new ResponseEntity<Workstation>(worksService.findWorkstationById(id), HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllWorkstations() {
		return new ResponseEntity<List<Workstation>>(worksService.findAllWorkstations(), HttpStatus.FOUND);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<?> getAllWorkstationsPaged(Pageable pageable) {
		return new ResponseEntity<Page<Workstation>>(worksService.findAllWorkstations(pageable), HttpStatus.FOUND);
	}
	
	@GetMapping("/pageable/{city}")
	public ResponseEntity<?> getAllWorkstationsPagedPerCity(@PathVariable String city, Pageable pageable) {
		return new ResponseEntity<Page<Workstation>>(worksService.findWorkstationsByCity(city, pageable), HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> postNewWorkstation(@RequestBody Workstation works) {
		return new ResponseEntity<String>(worksService.persistWorkstation(works), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putWorkstation(@RequestBody Workstation works) {
		return new ResponseEntity<String>(worksService.updateWorkstation(works), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteWorkstation(@RequestBody Workstation works) {
		return new ResponseEntity<String>(worksService.removeWorkstation(works), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteWorkstationById(@PathVariable Long id) {
		return new ResponseEntity<String>(worksService.removeWorkstation(id), HttpStatus.OK);
	}
	
}
