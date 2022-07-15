package com.sofka.project.TDF.repository;

import com.sofka.project.TDF.model.Country;
import com.sofka.project.TDF.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepositroy extends JpaRepository<Team, Long> {

    List<Team> findByCountry(Country country);
}
