package com.sofka.project.TDF.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cyclist")
public class Cyclist {
    @Id
    @Column(name = "id_cyclist")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cyclist;

    @Column(name = "name_team", nullable = false, length = 30, unique = false)
    private String name_cyclist;

    @Column(name = "number_shirt", nullable = false, length = 3, unique = true)
    private Integer number_shirt;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team team;

}