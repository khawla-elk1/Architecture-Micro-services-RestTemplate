package com.example.car.repositories; // Ajustez ce package selon votre structure

import com.example.car.entities.Car; // Importez votre classe Car
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Ajoutez des méthodes de recherche personnalisées ici.
    // Par exemple, pour trouver toutes les voitures d'un client spécifique:
    List<Car> findByClientId(Long clientId);

}