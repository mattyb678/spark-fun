package model;

import java.util.HashMap;
import java.util.Map;

public class Zoo {
    private String zooName;
    private Map<String, Integer> feedInventory;

    public Zoo (String name) {
        zooName = name;
        feedInventory = new HashMap<>();
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
