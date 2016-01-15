package services;

import model.Animal;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AnimalService {

    private Map<UUID, Animal> animals;
    public AnimalService () {
        animals = new HashMap<>();
    }

    public UUID add (String speciesName) {
        Animal newAnimal = new Animal(speciesName);
        animals.put(newAnimal.getId(), newAnimal);
        return newAnimal.getId();
    }
}
