package com.proyecto.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;


	@Entity
	@Table(name = "AVAILABILITIES")
	public class Availabilities {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private Integer id;
		@Column(name = "DATE")
		private Date date;
		//@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "ID_HOTEL")
		private Integer id_hotel;
		@Column(name = "ROOMS", length = 2)
		private Integer rooms;
		
		

		public Availabilities() {
			super();
		}

		public Availabilities(Integer id, Date date, Integer id_hotel, Integer rooms) {
			super();
			this.id = id;
			this.date = date;
			this.id_hotel = id_hotel;
			this.rooms=rooms;
			
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Integer getId_hotel() {
			return id_hotel;
		}

		public void setId_hotel(Integer id_hotel) {
			this.id_hotel = id_hotel;
		}

		public Integer getRooms() {
			return rooms;
		}

		public void setRooms(Integer rooms) {
			this.rooms = rooms;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		
	}




