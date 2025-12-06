package com.example.car.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String matricule;

    // CORRECTION: Changement du nom du champ en CamelCase (clientId)
    // et utilisation de @Column pour mapper à la colonne SQL 'client_id'
    @Column(name = "client_id")
    private Long clientId;
}