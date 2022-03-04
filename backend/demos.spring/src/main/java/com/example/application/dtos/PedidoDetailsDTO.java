package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PedidoDetailsDTO {
	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("cliente")
	private String customer;
	@JsonProperty("title")
	private String title;
	private String empleado;//staff
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date rentalDate;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;	
	private List<PaymentDetailsDTO> payments;

	public static PedidoDetailsDTO from(Rental source) {
		return new PedidoDetailsDTO(
				source.getRentalId(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getInventory().getFilm().getTitle(),
				source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
				source.getRentalDate(),
				source.getReturnDate(),
				source.getPayments().stream().map(pago -> PaymentDetailsDTO.from(pago)).toList()
				);
	}
}
