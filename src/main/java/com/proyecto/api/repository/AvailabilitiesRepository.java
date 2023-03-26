package com.proyecto.api.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.api.entity.Availabilities;



public interface AvailabilitiesRepository extends JpaRepository<Availabilities, Integer>, JpaSpecificationExecutor<Availabilities>{

	
	
	
	@Query(value="select a from Availabilities a where a.id_hotel = :id_hotel and a.date between :fecha1 and :fecha2")
	List<Availabilities> findbyhotelandtwodates(Integer id_hotel, Date fecha1, Date fecha2);
	
	
	@Query(value="select a from Availabilities a where a.id_hotel = :id_hotel and a.date = :fecha1")
	Availabilities findbyhotelanddate(Integer id_hotel, Date fecha1);
	
	
	  
	//List<Availabilities> consultarAvailability(Date fecha1, Date fecha2, String nombre, Integer categoria);
	
	
	

	
	
	
}
