package com.sofka.project.TDF.service;

import com.sofka.project.TDF.model.Country;
import com.sofka.project.TDF.model.Cyclist;
import com.sofka.project.TDF.repository.CyclistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CyclistService {

    @Autowired
    private CyclistRepository cyclistRepository;

    public List<Cyclist> getAllCyclists(){
        return cyclistRepository.findAll();
    }

    public String saveCyclist(Cyclist cyclist){
        var ciclistActived = cyclistRepository.findByTeam(cyclist.getTeam());

        if(ciclistActived.size() < 8) {
            System.out.println(ciclistActived.size());
            cyclistRepository.save(cyclist);
            return "registro creado exitosamente";
        }else{
            return null;
        }
    }

    public void deleteCyclist(Long id){
        cyclistRepository.deleteById(id);
    }

    public Optional<Cyclist> findCyclistById(Long id ){
        return cyclistRepository.findById(id);
    }

    public List<Cyclist> findCyclistByCountry(Long id){
        Country country = new Country();
        country.setId_country(id);
        return cyclistRepository.findByCountry(country);
    }
}
