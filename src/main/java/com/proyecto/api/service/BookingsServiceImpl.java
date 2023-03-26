package com.proyecto.api.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.proyecto.api.entity.Availabilities;
import com.proyecto.api.entity.Bookings;
import com.proyecto.api.entity.Hotels;
import com.proyecto.api.repository.AvailabilitiesRepository;
import com.proyecto.api.repository.BookingsRepository;

@Service
public class BookingsServiceImpl implements BookingsService{
	
	private BookingsRepository bookingsrepository;
	private AvailabilitiesRepository avaiRepository;
	
	public BookingsServiceImpl(BookingsRepository bookingsrepository, AvailabilitiesRepository avaiRepository) {
		this.bookingsrepository = bookingsrepository;
		this.avaiRepository = avaiRepository;
	}

	
	@Override
	@Transactional
	public Bookings eliminar(Integer id) {
		Bookings b = bookingsrepository.findById(id).get();
		Date fecha1 = b.getDate_from();
		Date fecha2 = b.getDateto();
		Integer id_hotel = b.getId_hotel();
		
		List<Availabilities> availabilities = avaiRepository.findbyhotelandtwodates(id_hotel,fecha1, fecha2);
		 if(availabilities != null) {
		for(int x = 0; x<availabilities.size();x++)	 {
		 Availabilities a = availabilities.get(x);
		 a.setRooms(a.getRooms()+1);
		 avaiRepository.save(a); 
		}
		 }
		 bookingsrepository.delete(b);
		
		return b;
	}
	
	
	@Override
	public List<Object> search(Integer idBooking) {
		return bookingsrepository.findBooking(idBooking);
	}
	

	
	@Override
	public List<Bookings> consultar(Integer id_hotel, Date fecha1, Date Fecha2) {
		return bookingsrepository.findbyhotelandtwodates(id_hotel, fecha1, Fecha2);
	}
	
	
	
	@Override
	@Transactional
	public Bookings crearBooking(Date fecha1, Date fecha2, String email, Integer id_hotel) {
		
		List<Availabilities> availabilities = avaiRepository.findbyhotelandtwodates(id_hotel,fecha1, fecha2);
		 if(availabilities != null) {
		for(int x = 0; x<availabilities.size();x++)	 {
		 Availabilities a = availabilities.get(x);
		 a.setRooms(a.getRooms()-1);
		 avaiRepository.save(a); 
		}
		 }
		Bookings booking = new Bookings();
		booking.setDate_from(fecha1);
		booking.setDateto(fecha2);
		booking.setEmail(email);
		booking.setId_hotel(id_hotel);
		return bookingsrepository.save(booking);
	
	
}
	}
