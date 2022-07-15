package com.sofka.project.TDF.repository;

import com.sofka.project.TDF.model.Country;
import com.sofka.project.TDF.model.Cyclist;
import com.sofka.project.TDF.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
    List<Cyclist> findByTeam(Team team);

    List<Cyclist> findByCountry(Country country);
}
