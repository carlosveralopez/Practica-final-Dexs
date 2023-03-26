package com.proyecto.api.dto;

import java.sql.Date;

public class BookingsDto {
private Integer id;
private Date date_from;
private Date date_to;
private String email;
private Integer id_hotel;
public BookingsDto(Integer id, Date date_from, Date date_to, Integer id_hotel,String email) {
	super();
	this.id = id;
	this.date_from = date_from;
	this.date_to = date_to;
	this.email = email;
	this.setId_hotel(id_hotel);
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getDate_from() {
	return date_from;
}
public void setDate_from(Date date_from) {
	this.date_from = date_from;
}
public Date getDate_to() {
	return date_to;
}
public void setDate_to(Date date_to) {
	this.date_to = date_to;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getId_hotel() {
	return id_hotel;
}
public void setId_hotel(Integer id_hotel) {
	this.id_hotel = id_hotel;
}


}
