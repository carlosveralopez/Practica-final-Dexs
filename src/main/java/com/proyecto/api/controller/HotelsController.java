package com.proyecto.api.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.api.dto.HotelsDto;
import com.proyecto.api.entity.Hotels;
import com.proyecto.api.mapper.HotelsMapper;
import com.proyecto.api.service.HotelsService;

@RestController
public class HotelsController {

	private HotelsService hotelservice;
	private HotelsMapper hotelsmapper;
	public HotelsController(HotelsService hotelservice, HotelsMapper hotelsmapper) {
		this.hotelservice = hotelservice;
		this.hotelsmapper = hotelsmapper;
	}
	
	@GetMapping(value = "/hotels", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HotelsDto> listarHoteles() {
		List<Hotels> listarHoteles = hotelservice.listarHoteles();
		return listarHoteles.stream().map(hotelsmapper::mapToDto).collect(Collectors.toList());
	}

	@PostMapping(value = "/hotels", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Hotels crearHotel(@RequestBody Hotels hotel) {

		hotelservice.guardarHotel(hotel);

		return hotel;
	}

	@GetMapping(value = "/hotels/{idHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hotels buscarHotel(@PathVariable(value = "idHotel") Integer idHotel) {
		return hotelservice.buscarHotel(idHotel);
	}

	@PutMapping(value = "/hotels/{idHotel}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Hotels modificarHotel(@PathVariable(value = "idHotel") Integer idHotel,
			@RequestBody Hotels hotel) {
		hotel.setId(idHotel);
		hotelservice.guardarHotel(hotel);

		return hotel;
	}

	@DeleteMapping(value = "/hotels/{idHotel}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarHotel(@PathVariable(value = "idHotel") Integer idHotel) {
		hotelservice.eliminarHotel(idHotel);

	}
}
