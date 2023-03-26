package com.proyecto.api.service;

import java.sql.Date;
import java.util.List;

import com.proyecto.api.entity.Availabilities;
import com.proyecto.api.entity.Bookings;
import com.proyecto.api.entity.Hotels;

public interface BookingsService {

	Bookings crearBooking(Date fecha1, Date fecha2, String email, Integer id_hotel);
	
	List<Bookings> consultar(Integer id_hotel, Date fecha1, Date Fecha2);
	
	Bookings eliminar(Integer id);
	
	List<Object> search(Integer idBooking);
}
