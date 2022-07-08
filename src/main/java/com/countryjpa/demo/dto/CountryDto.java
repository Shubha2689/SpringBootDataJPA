package com.countryjpa.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CountryDto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	int Id;
	String CountryName;
	String CountryCapital;
	
	public CountryDto(int Id,String CountryName,String CountryCapital) {
		this.Id=Id;
		this.CountryName=CountryName;
		this.CountryCapital=CountryCapital;
		
	}
	

	public CountryDto() {
		super();
		
	}


	@Override
	public String toString() {
		return "CountryDto [Id=" + Id + ", CountryName=" + CountryName + ", CountryCapital=" + CountryCapital + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public String getCountryCapital() {
		return CountryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		CountryCapital = countryCapital;
	}

}
