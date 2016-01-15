package model;

import services.AnimalService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Zoo {
    private String zooName;
    private Map<String, Integer> feedInventory;
    private AnimalService animalService;

    public Zoo (String name) {
        zooName = name;
        feedInventory = new HashMap<>();
        animalService = new AnimalService();
    }

    public void feedAnimal (FeedRequest request) {
        addFeed(request.getFood(), -1 * request.getAmount());
        animalService.feed(request);
    }

    public Map<String, Map<Date, List<FeedRequest>>> stats () {
        return animalService.stats();
    }

    public UUID addAnimal (String speciesName) {
        return animalService.add(speciesName);
    }

    public void addFeed (String feedName, int amount) {
        int oldAmt = feedInventory.getOrDefault(feedName, 0);
        feedInventory.put(feedName, oldAmt + amount);
    }

    public int getAmount (String feedName) {
        return feedInventory.getOrDefault(feedName, 0);
    }

    public void setZooName (String name) {
        zooName = name;
    }

    public String getZooName () {
        return zooName;
    }
}
