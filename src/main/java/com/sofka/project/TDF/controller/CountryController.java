package com.sofka.project.TDF.controller;

import com.sofka.project.TDF.model.Country;
import com.sofka.project.TDF.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Country>> getAllCountries(){
        var countries = countryService.getAllCountries();
        return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        countryService.saveCountry(country);
        return new ResponseEntity<Country>(country, null, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable("id") Long id){

        try {
            countryService.deleteCountry(id);
            return new ResponseEntity<Country>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Country>> getCountryByID(@PathVariable("id") Long id){

            var country = countryService.findCountryById(id);

            if(!country.isPresent())return new ResponseEntity<Optional<Country>>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<Optional<Country>>(country, null, HttpStatus.OK);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Country> updateCountryById(@PathVariable("id") Long id, @RequestBody Country countryUpdated){
        var updated = countryService.findCountryById(id)
                .map(country ->{
                    country.setName_country(countryUpdated.getName_country());
                    country.setCode_country(countryUpdated.getCode_country());
                    return countryService.saveCountry(country);
                }).orElseGet(() ->{
                    countryUpdated.setId_country(id);
                    return countryService.saveCountry(countryUpdated);
                });

        return new ResponseEntity<Country>(updated, HttpStatus.CREATED);
    }


}
