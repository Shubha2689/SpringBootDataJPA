package com.countryjpa.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryjpa.demo.dto.CountryDto;
import com.countryjpa.demo.service.CountryService;


@RestController
public class CountryJpaController {
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getalldetails")
	public List< CountryDto> Getalldetails(){
		return countryService.getAlldetails();
		
	}
	@GetMapping("/getalldetails/{id}")
	public ResponseEntity<CountryDto> getCountryById(@PathVariable(value="id")int id){
		try {
			CountryDto dto= countryService.getCountryById(id);
			return new ResponseEntity<CountryDto>(dto,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		@GetMapping("/getalldetails/countryName")
		public ResponseEntity<CountryDto> getCountryById(@RequestParam(value="name")String  name){
			try {
				CountryDto dto= countryService.getCountryByName(name);
				return new ResponseEntity<CountryDto>(dto,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		
	}
	@PostMapping("/addcountry")
	public CountryDto addRequest(@RequestBody CountryDto country) {
		
		return countryService.addRecord(country);
	}
	
	@PutMapping("/updatecountry")
	public ResponseEntity<CountryDto> updateCountry(@PathVariable(value="id")int id,@RequestBody CountryDto country) 
	{
		try {
			CountryDto existCountry=countryService.getCountryById(id);
			existCountry.setCountryName(country.getCountryName());
			existCountry.setCountryCapital(country.getCountryCapital());
			
			CountryDto updated_country=countryService.upDateCountry(existCountry);
			
			return new ResponseEntity<CountryDto>(updated_country,HttpStatus.OK);
			
			
		}
		catch (Exception e) {
			
			return new ResponseEntity<CountryDto>(HttpStatus.CONFLICT);
		}
		
		
	}
	
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		
	    countryService.getDeleteById(id);
		
		
		 return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
		 
		 	
	}

	

}
