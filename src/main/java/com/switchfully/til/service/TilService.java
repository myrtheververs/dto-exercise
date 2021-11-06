package com.switchfully.til.service;

import com.switchfully.til.domain.Til;
import com.switchfully.til.dto.CreateTilDto;
import com.switchfully.til.dto.ViewTilDto;
import com.switchfully.til.mapper.TilMapper;
import com.switchfully.til.repository.TilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TilService {
    private final TilRepository tilRepository;
    private final TilMapper tilMapper;

    public TilService(TilRepository tilRepository, TilMapper tilMapper) {
        this.tilRepository = tilRepository;
        this.tilMapper = tilMapper;
    }



    public List<ViewTilDto> getTils() {
        return tilMapper.toViewDto(tilRepository.getTils());
    }


    public Til addTil(CreateTilDto createTilDto) {
        return tilMapper.toEntity(createTilDto);
    }

/*
    public Til addTil(Til tilToAdd) {
        return tilRepository.addTil(tilToAdd);
    }
*/

    public void removeTil(String id) {
        tilRepository.deleteTil(UUID.fromString(id));
    }
}
