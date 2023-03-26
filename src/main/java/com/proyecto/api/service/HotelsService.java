package com.proyecto.api.service;

import java.util.List;

import com.proyecto.api.entity.Hotels;



public interface HotelsService {
	List<Hotels> listarHoteles();

	Hotels buscarHotel(Integer id);

	Hotels guardarHotel(Hotels hotel);

	void eliminarHotel(Integer idHotel);

}
