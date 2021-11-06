package com.switchfully.til.domain;

import java.util.Objects;
import java.util.UUID;

public class Til {

    private final String owner;
    private final String knowledgeOfTheDay;
    private final UUID uuid;

    // UI needs ownerName
    // UI also needs temployee
    //       Postman needs owner
    //       In java, a Person is needed

    // UI needs til
    //      Postman needs knowledgeOfTheDay

    // UI needs tid
    //      Postman needs uuid

    public Til(String owner, String knowledgeOfTheDay) {
        this.owner = owner;
        this.knowledgeOfTheDay = knowledgeOfTheDay;
        this.uuid = UUID.randomUUID();
    }

    public String getOwner() {
        return owner;
    }

    public String getKnowledgeOfTheDay() {
        return knowledgeOfTheDay;
    }

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

    @Override
    public String toString() {
        return "Til{" +
                "owner='" + owner + '\'' +
                ", knowledgeOfTheDay='" + knowledgeOfTheDay + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
