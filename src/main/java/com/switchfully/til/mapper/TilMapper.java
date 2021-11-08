package com.switchfully.til.mapper;

import com.switchfully.til.domain.Til;
import com.switchfully.til.service.dto.CreateTilDto;
import com.switchfully.til.service.dto.ViewTilDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TilMapper {


    public List<ViewTilDto> toViewDto(List<Til> tils) {
        return tils.stream()
                .map(this::toViewDto)
                .collect(Collectors.toList());
    }

    public ViewTilDto toViewDto(Til til) {
        return new ViewTilDto(til.getUuid().toString(), til.getOwner(), til.getKnowledgeOfTheDay());
    }

    public ViewTilDto toViewDto(CreateTilDto createTilDto) {
        Til til = new Til(createTilDto.getOwnerName(), createTilDto.getTil());
        return toViewDto(til);
    }

    public Til toEntity(CreateTilDto createTilDto) {
        return new Til(createTilDto.getOwnerName(), createTilDto.getTil());
    }
}
