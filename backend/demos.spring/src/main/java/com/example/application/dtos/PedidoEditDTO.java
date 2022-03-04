package com.example.application.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

@ApiModel(value = "Alquiler editable", description = "Version editable de los alquileres.")
@Value @Data
public class PedidoEditDTO {
	@JsonProperty("id")
	private int rentalId;
	@ApiModelProperty(value = "Fecha (preestablecida)")
	private Date rentalDate;
	@ApiModelProperty(value = "Id del inventario")
	private int inventory;
	@ApiModelProperty(value = "Id del cliente")
	private int customer;
	@ApiModelProperty(value = "Fecha null al crear un alquiler, se actualiza automaticamente al añadir un pago")
	private Date returnDate; 
	@ApiModelProperty(value = "Id del empleado")
	private int staff;
	@ApiModelProperty(value = "Id de la pelicula")
	private int film;
	private List<PaymentEditDTO> payments;

	public static PedidoEditDTO from(Rental source) {
		return new PedidoEditDTO(
				source.getRentalId(), 
				source.getRentalDate(), 
				source.getInventory().getInventoryId(),
				source.getCustomer().getCustomerId(),
				source.getReturnDate() == null ? null : source.getReturnDate(),
				source.getStaff().getStaffId(),
				source.getInventory().getFilm().getFilmId(),
				source.getPayments().stream().map(item -> PaymentEditDTO.from(item)).toList()
				);
	}
	public static Rental from(PedidoEditDTO source) {
		return new Rental (
				source.getRentalId(),
				source.getRentalDate(),
				source.getReturnDate() == null ? null : source.getReturnDate(),
				new Customer(source.getCustomer()),
				new Inventory(source.getInventory()),
				new Staff(source.getStaff()));
	}
	
	public Rental update(Rental target) {
		target.setRentalDate(rentalDate);
		target.setReturnDate(returnDate);
		target.setCustomer(new Customer(customer));
		target.setInventory(new Inventory(inventory));
		target.setStaff(new Staff(staff));
		
		
			// Borra los alquileres que sobran
			var delAlquiladas = target.getPayments().stream()
					.filter(item -> payments.stream().noneMatch(pago -> pago.getPaymentId() == item.getPaymentId()))
					.toList();
			delAlquiladas.forEach(item -> target.removePayment(item));
			// Modifica los que han quedado
			target.getPayments().forEach(item -> {
				var nuevoPago = payments.stream().filter(pago -> pago.getPaymentId() == item.getPaymentId()).findFirst().get();
				if (item.getAmount() != nuevoPago.getAmount()) {	
					item.setAmount(nuevoPago.getAmount());
				}
				if (item.getPaymentDate() != nuevoPago.getFecha()) {	
					item.setPaymentDate(nuevoPago.getFecha());
				}
				if(item.getStaff().getStaffId() != nuevoPago.getStaff()) {
					item.setStaff(new Staff(nuevoPago.getStaff()));
				}
			});
//			// Añade los alquileres que faltan
			payments.stream()
				.filter(paymentDTO -> target.getPayments().stream().noneMatch(alquiler -> alquiler.getPaymentId() == paymentDTO.getPaymentId()))
				.forEach(paymentDTO -> target.addPayment(new Payment(
						paymentDTO.getPaymentId(),
						paymentDTO.getAmount(),
						paymentDTO.getFecha(),
						new Staff(paymentDTO.getStaff()),
						target)));
			return target;
	}
}
