package com.proyecto.api.controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.api.entity.Availabilities;
import com.proyecto.api.mapper.AvailabilitiesMapper;
import com.proyecto.api.service.AvailabilitiesService;


@RestController
public class AvailabilitiesController {

	private AvailabilitiesService availabilitiesservice;
	private AvailabilitiesMapper availabilitiesmapper;
	public AvailabilitiesController( AvailabilitiesService availabilitiesservice, AvailabilitiesMapper availabilitiesmapper) {
		this.availabilitiesservice = availabilitiesservice;
		this.availabilitiesmapper = availabilitiesmapper;
	}
	
	
   // Abrir disponibilidad , aumenta el numero de habitaciones en caso de que ya exista la disponibilidad
	@PostMapping(value = "/Availabilities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Availabilities> crearAvailability(@RequestParam(name = "fecha1", required = true) Date fecha1,
			@RequestParam(name = "fecha2", required = true) Date fecha2,
			@RequestParam(name = "id_hotel", required = true) Integer id_hotel,
			@RequestParam(name = "rooms", required = true) Integer rooms) {

		
		return availabilitiesservice.guardarAvailability(fecha1, fecha2, id_hotel, rooms);
	}
	//Consulta la disponibilidad del hotel, 
	@GetMapping(value = "/Availabilities/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Availabilities> buscarAvailabilities(@RequestParam(name = "fecha1", required = true) Date fecha1,
			@RequestParam(name = "fecha2", required = true) Date fecha2,
			@RequestParam(name = "nombre", required = false) String nombre,
			@RequestParam(name = "category", required = false) Integer category) {
		return availabilitiesservice.consultarAvailability(fecha1, fecha2, nombre, category);
	}

	
}
