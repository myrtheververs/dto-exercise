package com.switchfully.til.service.dto;

public class ViewTilDto {
    private final String tid;       //til id
    private final String temployee; //owner
    private final String til;       //knowledge of the day

    public ViewTilDto(String tid, String temployee, String til) {
        this.tid = tid;
        this.temployee = temployee;
        this.til = til;
    }

    public String getTid() {
        return tid;
    }

    public String getTemployee() {
        return temployee;
    }

    public String getTil() {
        return til;
    }
}
