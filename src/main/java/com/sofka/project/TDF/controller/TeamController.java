package com.sofka.project.TDF.controller;

import com.sofka.project.TDF.model.Team;
import com.sofka.project.TDF.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Team>> getAllTeams(){
        var teams = teamService.getAllTeams();
        return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Team> createTeam(@RequestBody Team team){
        var teamcreated = teamService.saveTeam(team);
        return new ResponseEntity<Team>(teamcreated, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable("id")  Long id){
        try {
            teamService.deleteTeam(id);
            return new ResponseEntity<Team>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Team>> getTeamByID(@PathVariable("id") Long id){
        var teamFound =  teamService.findTeamById(id);
        if(!teamFound.isPresent()) return new ResponseEntity<Optional<Team>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Optional<Team>>(teamFound, HttpStatus.OK);
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
