package com.sofka.project.TDF.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {
    @Id
    @Column(name = "id_team", nullable = false)
    private Long id_team;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

}