package com.sofka.project.TDF.service;

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

    public Cyclist saveCyclist(Cyclist cyclist){
        return cyclistRepository.save(cyclist);
    }

    public void deleteCyclist(Long id){
        cyclistRepository.deleteById(id);
    }

    public Optional<Cyclist> findCyclistById(Long id ){
        return cyclistRepository.findById(id);
    }
}
