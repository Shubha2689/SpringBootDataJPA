package com.countryjpa.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.countryjpa.demo.doa.CountryJpaDoa;
import com.countryjpa.demo.dto.CountryDto;
import com.countryjpa.demo.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryJpaDoa countryJpaDoa;

	public List<CountryDto> getAlldetails() {
		return countryJpaDoa.findAll();

	}

	public CountryDto addRecord(CountryDto dto) {

		dto.setId(getMaxId());
		return countryJpaDoa.save(dto);
	}

	public int getMaxId() {

		return countryJpaDoa.findAll().size() + 1;

	}

	public CountryDto upDateCountry(CountryDto dto) {

		return countryJpaDoa.save(dto);

	}

	public void getDeleteById(int id) {
		countryJpaDoa.deleteById(id);
	}

	@Override
	public CountryDto getCountryById(int id) {

		return countryJpaDoa.findById(id).get();
	}

	@Override
	public CountryDto getCountryByName(String name) {
		List<CountryDto> ListCountries = countryJpaDoa.findAll();
		CountryDto dto = null;
		for (CountryDto countryDto : ListCountries) {
			if (countryDto.getCountryName().equalsIgnoreCase(name))

				dto = countryDto;
		}
		return dto;

	}

}
