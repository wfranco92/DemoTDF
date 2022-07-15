package com.sofka.project.TDF.controller;

import com.sofka.project.TDF.model.Cyclist;
import com.sofka.project.TDF.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/cyclist")
public class CyclistController {

    @Autowired
    private CyclistService cyclistService;

    @GetMapping()
    public ResponseEntity<List<Cyclist>> getAllCyclists(){
        var cyclists = cyclistService.getAllCyclists();
        return new ResponseEntity<List<Cyclist>>(cyclists, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createCyclist(@RequestBody Cyclist cyclist){
        var newCyclist = cyclistService.saveCyclist(cyclist);
        if(newCyclist == null) return new ResponseEntity<String>("el team ya cuenta con el maximo de ciclistas", HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<String>(newCyclist, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Cyclist> deleteCyclist(@PathVariable("id") Long id){

        try {
            cyclistService.deleteCyclist(id);
            return new ResponseEntity<Cyclist>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Cyclist>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Cyclist>> getCyclistByID(@PathVariable("id") Long id){
        var cyclistFound = cyclistService.findCyclistById(id);
        if(!cyclistFound.isPresent()) return new ResponseEntity<Optional<Cyclist>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Optional<Cyclist>>(cyclistFound, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateCyclistById(@PathVariable("id") Long id, @RequestBody Cyclist cyclistUpdated){
        var cyclistUpdate = cyclistService.findCyclistById(id)
                .map(cyclist ->{
                    cyclist.setName_cyclist(cyclistUpdated.getName_cyclist());
                    cyclist.setNumber_shirt(cyclistUpdated.getNumber_shirt());
                    cyclist.setCountry(cyclistUpdated.getCountry());
                    cyclist.setTeam(cyclistUpdated.getTeam());
                    return cyclistService.saveCyclist(cyclist);

                }).orElseGet(() ->{
                    cyclistUpdated.setId_cyclist(id);
                    return cyclistService.saveCyclist(cyclistUpdated);
                });
        return new ResponseEntity<String>("registroactualizado", HttpStatus.OK);
    }
}
