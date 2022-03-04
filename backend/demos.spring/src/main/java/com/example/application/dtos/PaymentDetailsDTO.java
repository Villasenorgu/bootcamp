package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.example.domains.entities.Film;
import com.example.domains.entities.Payment;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PaymentDetailsDTO {
	@JsonProperty("id")
	private int paymentId;
	private String staff;
	private BigDecimal amount;
	private Date fecha;

	public static PaymentDetailsDTO from(Payment source) {
		return new PaymentDetailsDTO(
				source.getPaymentId(),
				source.getStaff().getFirstName(),
				source.getAmount(),
				source.getPaymentDate()
				);
	}
}
