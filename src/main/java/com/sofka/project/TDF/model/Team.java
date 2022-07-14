package com.sofka.project.TDF.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {
    @Id
    @Column(name = "id_team")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_team;

    @Column(name = "name_team", nullable = false, length = 30, unique = false)
    private String name_team;

    @Column(name = "code_team", nullable = false, length = 5, unique = true)
    private String code_team;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Cyclist> cyclists;

}