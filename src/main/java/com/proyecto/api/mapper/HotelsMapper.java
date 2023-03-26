package com.proyecto.api.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.api.dto.HotelsDto;
import com.proyecto.api.entity.Hotels;



@Component
public class HotelsMapper {
	public HotelsDto mapToDto(Hotels hotel) {
		return new HotelsDto(hotel.getId(), hotel.getName(), hotel.getCategory());
	}

	public Hotels mapToEntity(HotelsDto hotel) {
		return new Hotels(hotel.getId(), hotel.getName(), hotel.getCategory());
	}
}
