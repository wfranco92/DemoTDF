package com.sofka.project.TDF.service;

import com.sofka.project.TDF.model.Country;
import com.sofka.project.TDF.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country saveCountry(Country country){
        return countryRepository.save(country);
    }

    public void deleteCountry(Long id){
        countryRepository.deleteById(id);
    }

    public Optional<Country> findCountryById(Long id ){
        return countryRepository.findById(id);
    }
}
