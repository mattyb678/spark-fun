package services;

import model.Animal;
import model.FeedRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

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

    public Map<String, Map<Date, List<FeedRequest>>> stats () {
        return feedRequests.stream()
                .collect(groupingBy(FeedRequest::getAnimalID,
                        groupingBy(FeedRequest::getDate)));
    }
}
