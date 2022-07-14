package com.sofka.project.TDF.controller;

import com.sofka.project.TDF.model.Country;
import com.sofka.project.TDF.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping()
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @PostMapping()
    public Country createCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCountry(@PathVariable("id") Long id){
        countryService.deleteCountry(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Country> getCountryByID(@PathVariable("id") Long id){
        return countryService.findCountryById(id);
    }

    @PutMapping(path = "/{id}")
    public Country updateCountryById(@PathVariable("id") Long id, @RequestBody Country countryUpdated){
        return countryService.findCountryById(id)
                .map(country ->{
                    country.setName_country(countryUpdated.getName_country());
                    country.setCode_country(countryUpdated.getCode_country());
                    return countryService.saveCountry(country);
                }).orElseGet(() ->{
                    countryUpdated.setId_country(id);
                    return countryService.saveCountry(countryUpdated);
                });
    }
}
