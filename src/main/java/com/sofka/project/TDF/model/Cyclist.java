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
    @Column(name = "id_cyclist", nullable = false)
    private Long id_cyclist;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

}