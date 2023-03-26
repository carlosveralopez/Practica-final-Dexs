package com.proyecto.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.proyecto.api.entity.Hotels;
import com.proyecto.api.repository.HotelsRepository;

@Service
public class HotelsServiceImpl implements HotelsService{

	private HotelsRepository hotelsrepository;
	
	public HotelsServiceImpl(HotelsRepository hotelsrepository) {
		this.hotelsrepository = hotelsrepository;
	}
	
	
	@Override
	public List<Hotels> listarHoteles() {
		return hotelsrepository.findAll();
	}

	@Override
	public Hotels buscarHotel(Integer id) {
		return hotelsrepository.findById(id).get();
	}

	@Override
	@Transactional
	public Hotels guardarHotel(Hotels hotel) {
		return hotelsrepository.save(hotel);
	}

	@Override
	@Transactional
	public void eliminarHotel(Integer idHotel) {
		hotelsrepository.deleteById(idHotel);
	}

	
	
}
