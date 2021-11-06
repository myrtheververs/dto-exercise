package com.switchfully.til.repository;

import com.switchfully.til.domain.Person;
import com.switchfully.til.domain.Til;
import com.switchfully.til.exception.NoSuchTilException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TilRepository {
    private final Map<Person, List<Til>> database;

    public TilRepository() {
        this.database = new HashMap<>();
    }

    
    public List<Til> getTils() {
        return database.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableList());
    }

    public Til addTil(Til newTil) {
        if (database.containsKey(new Person(newTil.getOwner()))) {
            database.get(new Person(newTil.getOwner())).add(newTil);
        } else {
            database.put(new Person(newTil.getOwner()), new ArrayList<>(List.of(newTil)));
        }
        return newTil;
    }

    public void deleteTil(UUID uuid) {
        Til tilToDelete = database.values().stream()
                .flatMap(Collection::stream)
                .filter(til -> til.getUuid().equals(uuid))
                .findAny().orElseThrow(NoSuchTilException::new);

        database.get(new Person(tilToDelete.getOwner())).remove(tilToDelete);
    }
}
