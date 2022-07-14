package com.sofka.project.TDF.controller;

import com.sofka.project.TDF.model.Country;
import com.sofka.project.TDF.model.Team;
import com.sofka.project.TDF.service.CountryService;
import com.sofka.project.TDF.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping()
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @PostMapping()
    public Team createTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTeam(@PathVariable("id")  Long id){
        teamService.deleteTeam(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Team> getTeamByID(@PathVariable("id") Long id){
        return teamService.findTeamById(id);
    }

    @PutMapping(path = "/{id}")
    public Team updateTeamById(@PathVariable("id") Long id, @RequestBody Team teamUpdated){
        return teamService.findTeamById(id)
                .map(team ->{
                    team.setName_team(teamUpdated.getName_team());
                    team.setCode_team(teamUpdated.getCode_team());
                    team.setCountry(teamUpdated.getCountry());
                    return teamService.saveTeam(team);
                }).orElseGet(() ->{
                    teamUpdated.setId_team(id);
                    return teamService.saveTeam(teamUpdated);
                });
    }
}
