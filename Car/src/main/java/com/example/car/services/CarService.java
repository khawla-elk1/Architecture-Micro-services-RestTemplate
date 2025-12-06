package com.example.car.services;

import com.example.car.models.Client;
import com.example.car.entities.Car;
import com.example.car.models.CarResponse;
import com.example.car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String CLIENT_SERVICE_URL =
            "http://localhost:8888/SERVICE-CLIENT/api/client/";

    public List<CarResponse> findAll() {
        List<Car> cars = carRepository.findAll();

        return cars.stream()
                .map(this::mapToCarResponse)
                .collect(Collectors.toList());
    }

    public CarResponse findById(Long id) throws Exception {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new Exception("Voiture non trouvée avec l'ID: " + id));

        return mapToCarResponse(car);
    }

    private CarResponse mapToCarResponse(Car car) {
        // Récupération du client depuis le service client
        Client client = null;
        try {
            // CORRECTION : Appel de la méthode getClientId() qui correspond au champ 'clientId'
            client = restTemplate.getForObject(
                    CLIENT_SERVICE_URL + car.getClientId(),
                    Client.class);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du client: " + e.getMessage());
        }

        // Construction de la réponse
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .matricule(car.getMatricule())
                .client(client)
                .build();
    }
}