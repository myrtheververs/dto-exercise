package com.switchfully.til.service;

import com.switchfully.til.domain.Til;
import com.switchfully.til.repository.TilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TilService {
    private final TilRepository tilRepository;

    public TilService(TilRepository tilRepository) {
        this.tilRepository = tilRepository;
    }


    public List<Til> getTils() {
        return tilRepository.getTils();
    }

    public Til addTil(Til tilToAdd) {
        return tilRepository.addTil(tilToAdd);
    }

    public void removeTil(String id) {
        tilRepository.deleteTil(UUID.fromString(id));
    }
}
