package services;

import model.Zoo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ZooService {
    private Map<UUID, Zoo> zoos;
    public ZooService () {
        zoos = new HashMap<>();
    }

    public UUID createZoo (String zooName) {
        UUID randUUID = UUID.randomUUID();
        while(zoos.containsKey(randUUID)) {
            randUUID = UUID.randomUUID();
        }

        Zoo newZoo = new Zoo(zooName);

        zoos.put(randUUID, newZoo);
        return randUUID;
    }

    public Zoo getZoo (UUID zooUUID) {
        return zoos.get(zooUUID);
    }

    public void deleteZoo (UUID zooUUID) {
        zoos.remove(zooUUID);
    }

    public int numberZoos () {
        return zoos.size();
    }
}
