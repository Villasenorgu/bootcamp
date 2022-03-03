package com.example.application.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Film;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Language;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PedidoEditDTO {
	@JsonProperty("id")
	private int rentalId;
	private Date rentalDate;
	private Inventory inventory;
	private Customer customer;
	private Date returnDate; 
	private Staff staff;
	private List<Payment> payments;
	private int film;

	public static PedidoEditDTO from(Rental source) {
		return new PedidoEditDTO(
				source.getRentalId(), 
				source.getRentalDate(), 
				source.getInventory(),
				source.getCustomer(),
				source.getReturnDate(),
				source.getStaff(),
				source.getPayments(),
				source.getInventory().getFilm().getFilmId());
	}
	public static Rental from(PedidoEditDTO source) {
		return new Rental (
				source.getRentalId(),
				source.getRentalDate(),
				source.getReturnDate(),
				source.getPayments(),
				source.getCustomer(),
				source.getInventory(),
				source.getStaff());
	}
}
