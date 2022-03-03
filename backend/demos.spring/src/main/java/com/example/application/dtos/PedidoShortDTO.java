package com.example.application.dtos;


import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PedidoShortDTO {
	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("titulo")
	private String title;

	public static PedidoShortDTO from(Rental source) {
		return new PedidoShortDTO(
				source.getRentalId(),
				source.getInventory().getFilm().getTitle()
				);
	}	
}
