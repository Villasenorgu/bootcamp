package com.example.application.dtos;


import com.example.domains.entities.City;
import com.example.domains.entities.Country;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class CityEditDTO {
	
	@JsonProperty("id")
	private int cityId;
	@JsonProperty("city")
	private String city;
	@JsonProperty("country")
	private int country;
	
	
	public static CityEditDTO from(City source) {
		return new CityEditDTO(
				source.getCityId(), 
				source.getCity(),
				source.getCountry().getCountryId());
	}
	public static City from(CityEditDTO source) {
		return new City(
				source.getCityId(), 
				source.getCity(),
				new Country(source.getCountry())
				);
	}

}
