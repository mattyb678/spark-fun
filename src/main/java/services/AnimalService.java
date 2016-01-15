package services;

import model.Animal;
import model.FeedRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AnimalService {
    private Map<UUID, Animal> animals;
    private List<FeedRequest> feedRequests;

    public AnimalService () {
        animals = new HashMap<>();
        feedRequests = new ArrayList<>();
    }

    public UUID add (String speciesName) {
        Animal newAnimal = new Animal(speciesName);
        animals.put(newAnimal.getId(), newAnimal);
        return newAnimal.getId();
    }

    public void feed (FeedRequest request) {
        feedRequests.add(request);
    }
}
