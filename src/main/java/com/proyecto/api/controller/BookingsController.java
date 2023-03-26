package com.proyecto.api.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.api.entity.Availabilities;
import com.proyecto.api.entity.Bookings;
import com.proyecto.api.entity.Hotels;
import com.proyecto.api.mapper.BookingMapper;
import com.proyecto.api.service.BookingsService;

@RestController
public class BookingsController {

	private BookingsService bookingservice;
	private BookingMapper bookingmapper;
	public BookingsController( BookingsService bookingservice, BookingMapper bookingmapper) {
		this.bookingservice = bookingservice;
		this.bookingmapper = bookingmapper;
	}

	
	@GetMapping(value = "/Bookings/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bookings> consultarBookings(@RequestParam(name = "fecha1", required = true) Date fecha1,
			@RequestParam(name = "fecha2", required = true) Date fecha2,
			@RequestParam(name = "id_hotel", required = true) Integer id_hotel) {
		return bookingservice.consultar(id_hotel,fecha1, fecha2);
	}
	
	
	@PostMapping(value = "/Bookings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Bookings crearBookings(@RequestParam(name = "fecha1", required = true) Date fecha1,
			@RequestParam(name = "fecha2", required = true) Date fecha2,
			@RequestParam(name = "id_hotel", required = true) Integer id_hotel,
			@RequestParam(name = "email", required = true) String email) {

		
		return bookingservice.crearBooking(fecha1, fecha2, email, id_hotel);
	}
	
	@PostMapping(value = "/Bookings/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Bookings eliminarBooking(@RequestParam(name = "id", required = true) Integer id) {

		
		return bookingservice.eliminar(id);
	}
	
	
	
	
	@GetMapping(value = "/Bookings", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> consultarBooking(@RequestParam(name = "id", required = true) Integer id) {
		return bookingservice.search(id);
	}
	
}
