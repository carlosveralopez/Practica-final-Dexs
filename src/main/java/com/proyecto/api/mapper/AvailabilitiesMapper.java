package com.proyecto.api.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.api.dto.AvailabilitiesDTO;
import com.proyecto.api.entity.Availabilities;



@Component
public class AvailabilitiesMapper {
	public AvailabilitiesDTO mapToDto(Availabilities availabilities) {
		return new AvailabilitiesDTO(availabilities.getId(), availabilities.getDate(), availabilities.getId_hotel(), availabilities.getRooms());
	}

	public Availabilities mapToEntity(AvailabilitiesDTO availabilitiesdto) {
		return new Availabilities(availabilitiesdto.getId(), availabilitiesdto.getDate(), availabilitiesdto.getId_hotel(), availabilitiesdto.getRooms());
	}
}