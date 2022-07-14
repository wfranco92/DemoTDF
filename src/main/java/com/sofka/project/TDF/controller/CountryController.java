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
    public void deleteCountry(@PathVariable Long id){
        countryService.deleteCountry(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Country> getCountryByID(@PathVariable Long id){
        return countryService.findCountryById(id);
    }
}
