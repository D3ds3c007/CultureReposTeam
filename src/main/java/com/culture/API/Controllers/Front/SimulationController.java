package com.culture.API.Controllers.Front;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Simulation;
import com.culture.API.Repository.SimulationRepository;



@RestController
@RequestMapping("/api")
public class SimulationController  {

    @Autowired
    SimulationRepository simulationRepository;

	@GetMapping("/simulation/logs")
	public ResponseEntity<List<Simulation>> findLogs() {

        List<Simulation> simulations = simulationRepository.findAll();
		
		return new ResponseEntity<>(simulations, HttpStatus.OK);
	}
}