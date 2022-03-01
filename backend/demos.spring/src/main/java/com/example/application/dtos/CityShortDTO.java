package com.example.application.dtos;

import javax.validation.constraints.NotBlank;

import com.example.domains.entities.City;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class CityShortDTO {
	
	@JsonProperty("id")
	private int cityId;
	@JsonProperty("city")
	private String city;
	
	
	public static CityShortDTO from(City source) {
		return new CityShortDTO(source.getCityId(), source.getCity());
	}

}
