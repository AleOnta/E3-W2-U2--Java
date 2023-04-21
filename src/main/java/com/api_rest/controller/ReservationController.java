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
import com.api_rest.model.Reservation;
import com.api_rest.service.ReservationServices;

@Controller
@RequestMapping("/E3W2U2/reservations")
public class ReservationController {
	
	@Autowired ReservationServices resService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getReservation(@PathVariable Long id) {
		return new ResponseEntity<Reservation>(resService.findReservationById(id), HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllReservations() {
		return new ResponseEntity<List<Reservation>>(resService.findAllReservation(), HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> postNewReservation(@RequestBody Reservation res) {
		return new ResponseEntity<String>(resService.persistReservation(res), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putReservation(@RequestBody Reservation res) {
		return new ResponseEntity<String>(resService.updateReservation(res), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteReservation(@RequestBody Reservation res) {
		return new ResponseEntity<String>(resService.removeReservation(res), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReservationById(@PathVariable Long id) {
		return new ResponseEntity<String>(resService.removeReservation(id), HttpStatus.OK);
	}
	
}
