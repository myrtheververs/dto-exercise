package com.switchfully.til;

import java.util.Objects;
import java.util.UUID;

public class Til {
    // UI needs ownerName
    // UI also needs temployee
    // Postman needs owner
    // In java, a Person is needed
    private final String owner;
    // UI needs til
    // Postman needs knowledgeOfTheDay
    private final String knowledgeOfTheDay;
    // UI needs tid
    // Postman needs uuid
    private final UUID uuid;

    public Til(String owner, String knowledgeOfTheDay, UUID uuid) {
        this.owner = owner;
        this.knowledgeOfTheDay = knowledgeOfTheDay;
        this.uuid = uuid;
    }

    // UI needs ownerName
    // UI also needs temployee
    // Postman needs owner
    public String getOwner() {
        return owner;
    }

    // UI needs til
    // Postman needs knowledgeOfTheDay
    public String getKnowledgeOfTheDay() {
        return knowledgeOfTheDay;
    }

    // UI needs tid
    // Postman needs uuid
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Til til = (Til) o;
        return Objects.equals(getUuid(), til.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }
}
