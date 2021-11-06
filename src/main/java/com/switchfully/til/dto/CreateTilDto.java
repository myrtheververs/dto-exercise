package com.switchfully.til.dto;

public class CreateTilDto {

    private final String ownerName;
    private final String til;

    public CreateTilDto(String ownerName, String til) {
        this.ownerName = ownerName;
        this.til = til;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTil() {
        return til;
    }

    @Override
    public String toString() {
        return "CreateTilDto{" +
                "ownerName='" + ownerName + '\'' +
                ", til='" + til + '\'' +
                '}';
    }
}
