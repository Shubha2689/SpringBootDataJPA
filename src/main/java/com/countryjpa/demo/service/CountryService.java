package com.countryjpa.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.countryjpa.demo.dto.CountryDto;

@Component
public interface CountryService  {
	
	public List<CountryDto> getAlldetails();
	public CountryDto addRecord(CountryDto dto);
	public CountryDto upDateCountry(CountryDto dto);
	public void getDeleteById(int id);
	public CountryDto getCountryById(int id);
	public CountryDto getCountryByName(String name);
	

}
