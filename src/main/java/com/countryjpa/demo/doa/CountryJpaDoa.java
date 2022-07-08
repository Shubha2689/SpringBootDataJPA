package com.countryjpa.demo.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.countryjpa.demo.dto.CountryDto;

@Component
public interface CountryJpaDoa extends JpaRepository<CountryDto, Integer>{

}
