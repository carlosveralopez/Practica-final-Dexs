package com.proyecto.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKINGS")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "DATE_FROM")
	private Date date_from;
	@Column(name = "DATE_TO")
	private Date date_to;
	@Column(name = "ID_HOTEL", length = 2)
	private Integer id_hotel;
	@Column(name = "EMAIL")
	private String email;
	

	public Bookings() {
		super();
	}

	public Bookings(Integer id, Date date_from, Date date_to, Integer id_hotel, String email) {
		super();
		this.id = id;
		this.date_from = date_from;
		this.date_to= date_to;
		this.id_hotel = id_hotel;
		this.email=email;
		
	}

	public Date getDateto() {
		return date_to;
	}

	public void setDateto(Date date_to) {
		this.date_to = date_to;
	}

	public Integer getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate_from() {
		return date_from;
	}

	public void setDate_from(Date date_from) {
		this.date_from = date_from;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}





