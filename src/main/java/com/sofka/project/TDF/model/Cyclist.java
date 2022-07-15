package com.sofka.project.TDF.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    @Max(value=999, message="Numero de camiseta no valido, debe contener maximo 3 digitos")
    @Min(value = 1, message="Numero de camiseta no valido, debe ser mayor a 0")
    private Integer number_shirt;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team team;

}