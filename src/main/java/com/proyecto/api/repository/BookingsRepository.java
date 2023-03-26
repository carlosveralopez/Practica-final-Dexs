package com.proyecto.api.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.api.entity.Availabilities;
import com.proyecto.api.entity.Bookings;



public interface BookingsRepository extends JpaRepository<Bookings, Integer>, JpaSpecificationExecutor<Bookings> {

	@Query(value="select * from bookings a where a.id_hotel = :id_hotel and a.date_to between :fecha1 and :fecha2 or a.date_from between :fecha1 and :fecha2", nativeQuery=true)
	List<Bookings> findbyhotelandtwodates(Integer id_hotel, Date fecha1, Date fecha2);
	
	@Query(value="select b.id as bid, b.date_to, b.date_from, b.id_hotel, b.email, h.id, h.name, h.category from bookings b join  hotels h on b.id_hotel = h.id where b.id_hotel = :idBooking", nativeQuery=true)
	 List<Object> findBooking(Integer idBooking);
	
}
