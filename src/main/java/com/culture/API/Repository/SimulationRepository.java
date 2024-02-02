package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culture.API.Models.*;

public interface SimulationRepository extends JpaRepository<Simulation, Integer> {

}
