package com.sofka.project.TDF.controller;

import com.sofka.project.TDF.model.Cyclist;
import com.sofka.project.TDF.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Cyclist> getAllCyclists(){
        return cyclistService.getAllCyclists();
    }

    @PostMapping()
    public Cyclist createCyclist(@RequestBody Cyclist cyclist){
        return cyclistService.saveCyclist(cyclist);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCyclist(@PathVariable("id") Long id){
        cyclistService.deleteCyclist(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Cyclist> getCyclistByID(@PathVariable("id") Long id){
        return cyclistService.findCyclistById(id);
    }

    @PutMapping(path = "/{id}")
    public Cyclist updateCyclistById(@PathVariable("id") Long id, @RequestBody Cyclist cyclistUpdated){
        return cyclistService.findCyclistById(id)
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
    }
}
