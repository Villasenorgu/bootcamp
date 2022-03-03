package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PedidoDetailsDTO {
	@JsonProperty("id")
	private int rentalId;
	private Date rentalDate;
	private int inventory;
	private int customer;
	private Date returnDate; 
	private int staff;
	private List<BigDecimal> payments;
	private String title;

	public static PedidoDetailsDTO from(Rental source) {
		return new PedidoDetailsDTO(
				source.getRentalId(), 
				source.getRentalDate(), 
				source.getInventory().getInventoryId(),
				source.getCustomer().getCustomerId(),
				source.getReturnDate(),
				source.getStaff().getStaffId(),
				source.getPayments().stream()
				.map(item -> item.getAmount()).toList(),
				source.getInventory().getFilm().getTitle());
	}
}
