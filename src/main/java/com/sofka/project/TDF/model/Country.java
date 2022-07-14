package com.sofka.project.TDF.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_country;

    @Column(name = "name_country", nullable = false, length = 30, unique = false)
    private String name_country;

    @Column(name = "name_country", nullable = false, length = 3, unique = true)
    private String code_country;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Team> teams;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cyclist> cyclists;

}
