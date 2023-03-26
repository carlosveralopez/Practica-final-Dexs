package com.proyecto.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.proyecto.api.entity.Availabilities;



public interface AvailabilitiesService {

	
	List<Availabilities> consultarAvailability(Date fecha1, Date fecha2, String nombre, Integer categoria);

	List<Availabilities> guardarAvailability(Date fecha1,Date fecha2,Integer id_hotel, Integer rooms);



	List<Availabilities> search(Integer id_hotel, Date fecha1, Date Fecha2);
	
	
}
