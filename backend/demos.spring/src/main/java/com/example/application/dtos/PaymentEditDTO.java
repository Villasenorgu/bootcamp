package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.example.domains.entities.Film;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PaymentEditDTO {
	@JsonProperty("id")
	private int paymentId;
	private int staff;
	private BigDecimal amount;
	private Date fecha;

	public static PaymentEditDTO from(Payment source) {
		return new PaymentEditDTO(
				source.getPaymentId(),
				source.getStaff().getStaffId(),
				source.getAmount(),
				source.getPaymentDate()
				);
	}
	
	public static Payment from(Payment source, Rental rental) {
		return new Payment(
				source.getPaymentId(),
				source.getAmount(),
				source.getPaymentDate(),
				new Staff(source.getStaff().getStaffId()),
				rental 
				);
	}
}
