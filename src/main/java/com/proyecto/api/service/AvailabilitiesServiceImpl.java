package com.proyecto.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import com.proyecto.api.entity.Availabilities;
import com.proyecto.api.entity.Bookings;
import com.proyecto.api.repository.AvailabilitiesRepository;



	@Service
	public class AvailabilitiesServiceImpl implements AvailabilitiesService{

		private AvailabilitiesRepository availabilitiesrepository;
		
		public AvailabilitiesServiceImpl(AvailabilitiesRepository availabilitiesrepository) {
			this.availabilitiesrepository = availabilitiesrepository;
		}
		
		
		//on duplicate key evita que se dupliquen los campos
		//idea1: crear availabilities atraves de un rango de fechas con rooms 0, actualizar todo el rango sumando el numero de rooms// date debe ser uk
		//necesitamos 1 metodo para crear availab y otro para actualizar
		

		//idea2: consultar availability a traves del rango de fechas y sumarles el numero de rooms, despues crear availabilities con el numero de rooms // date debe ser uk
		
		@Override
		public List<Availabilities> search(Integer id_hotel, Date fecha1, Date fecha2){
			List<Availabilities> availabilities = availabilitiesrepository.findbyhotelandtwodates(id_hotel, fecha1, fecha2);
			return availabilities;
		}
		
		

		@SuppressWarnings("deprecation")
		@Override
		@Transactional
		public List<Availabilities> guardarAvailability(Date fecha1,Date fecha2,Integer id_hotel, Integer rooms) {
			List<Availabilities> listav   ;
			while(fecha1.before(fecha2)) {
				
			
			Availabilities availabilities = availabilitiesrepository.findbyhotelanddate(id_hotel,fecha1);
			 if(availabilities != null) {
		            availabilities.setRooms(availabilities.getRooms()+rooms);
		        } else {
		            availabilities = new Availabilities();
		            availabilities.setId_hotel(id_hotel);
		            availabilities.setRooms(rooms);
		            availabilities.setDate(fecha1);
		            listav.add(availabilities);
		            
		            
		            
		        }
			 fecha1.setDate(fecha1.getDate()+1);
		}
		        return availabilitiesrepository.saveAll(listav);
		
		}

		
	    
	     /*   Availabilities save(String email, String phoneNumber) {
	            DeviceMetric deviceMetric = repo.findByField1AndField2AndField3("field1", "field", "field3")
	                .orElse(new DeviceMetric()); // create new object in a way that makes sense for you
	            deviceMetric.setEmail(email);
	           deviceMetric.setPhoneNumber(phoneNumber);
	        return repo.save(deviceMetric);
	    }*/
	

		
		@Override
//		public List<Pelicula> buscarPeliculas(FiltrosPelicula filtros) {
		public List<Availabilities> consultarAvailability(Date fecha1, Date fecha2, String nombre, Integer categoria) {
			Specification<Availabilities> spec = Specification.where(roomsSpec());

			if (fecha1 != null && fecha2 !=null) {
				Specification<Availabilities> fechaSpec = filtroFecha(fecha1, fecha2);
				spec = spec.and(fechaSpec);
				
			}
				if (nombre != null) {
					Specification<Availabilities> nombreSpec = filtroNombre(nombre);
					spec = spec.and(nombreSpec);
				}
			

			

			if (categoria != null) {
				Specification<Availabilities> categoriaSpec = filtroCategoria(categoria);
				spec = spec.and(categoriaSpec);
			}

			return availabilitiesrepository.findAll(spec);
		}

		private Specification<Availabilities> filtroFecha(Date fecha1, Date fecha2) {
			Specification<Availabilities> fechaSpec = (Root<Availabilities> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) -> criteriaBuilder.between(root.get("date"), fecha1, fecha2);
			return fechaSpec;
		}

		private Specification<Availabilities> filtroCategoria(Integer categoria) {
			Specification<Availabilities> categoriaSpec = (Root<Availabilities> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) -> criteriaBuilder.equal(root.get("categoria"), categoria);
			return categoriaSpec;
		}

		private Specification<Availabilities> roomsSpec() {
			Specification<Availabilities> roomsSpec = (Root<Availabilities> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("rooms"), 0);
			return roomsSpec;
		}
		
		private Specification<Availabilities> filtroNombre(String nombre) {
			return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%");
		}
		
		
}
