package model;

import java.util.UUID;

public class Animal {
    private String species;
    private UUID id;

    public Animal (String speciesName) {
        species = speciesName;
        id = UUID.randomUUID();
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
