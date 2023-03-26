package com.proyecto.api.mapper;

import org.springframework.stereotype.Component;


import com.proyecto.api.dto.BookingsDto;
import com.proyecto.api.entity.Bookings;


@Component
public class BookingMapper {

	public BookingsDto mapToDto(Bookings bookings) {
		return new BookingsDto(bookings.getId(), bookings.getDate_from(),  bookings.getDateto(), bookings.getId_hotel(),bookings.getEmail());
	}

	public Bookings mapToEntity(BookingsDto bookingsdto) {
		return new Bookings(bookingsdto.getId(), bookingsdto.getDate_from(),  bookingsdto.getDate_to(), bookingsdto.getId_hotel(),bookingsdto.getEmail());
	}
	
}
