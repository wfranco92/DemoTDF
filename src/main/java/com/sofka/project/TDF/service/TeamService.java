package com.sofka.project.TDF.service;

import com.sofka.project.TDF.model.Team;
import com.sofka.project.TDF.repository.TeamRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepositroy teamRepositroy;

    public List<Team> getAllTeams(){
        return teamRepositroy.findAll();
    }

    public Team saveTeam(Team team){
        return teamRepositroy.save(team);
    }

    public void deleteTeam(Long id){
        teamRepositroy.deleteById(id);
    }

    public Optional<Team> findTeamById(Long id ){
        return teamRepositroy.findById(id);
    }
}
