package com.culture.API.Controllers.Front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Culture;
import com.culture.API.Models.Plot;
import com.culture.API.Models.Ressource;
import com.culture.API.Models.Simulation;
import com.culture.API.Repository.ActionRepository;
import com.culture.API.Repository.SimulationDetailsRepository;
import com.culture.API.Repository.SimulationRepository;
import com.culture.API.Repository.YieldRepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class SimulationController {
    @Autowired
    YieldRepository yr; 
    @Autowired
    SimulationRepository sr;
    @Autowired
    SimulationDetailsRepository sdr;
    @Autowired
    ActionRepository ar;
    
    @PostMapping("/insertSimulation")
    public ResponseEntity<Simulation> insertSimulation(
        @RequestBody Plot plot, Culture culture, Ressource ressource, int quantity) {
        
        try {
            Simulation simulation = new Simulation();
            simulation = simulation.insertSimulation(yr, sr, sdr, ar, plot, culture, ressource, quantity);

            return new ResponseEntity<>(simulation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
