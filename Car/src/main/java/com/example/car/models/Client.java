package com.example.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) représentant un client.
 * Utilisé pour désérialiser la réponse JSON reçue
 * du microservice SERVICE-CLIENT via RestTemplate.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    // Doit correspondre à la structure de l'entité Client dans l'autre service.
    private Long id;
    private String nom; // Nom du client
    private Float age;  // Âge du client

    // Remarque: Lombok (@Data, @AllArgsConstructor, @NoArgsConstructor) génère
    // automatiquement les getters, setters et constructeurs nécessaires pour la désérialisation.
}