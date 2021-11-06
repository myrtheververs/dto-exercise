package com.switchfully.til.controller;

import com.switchfully.til.domain.Til;
import com.switchfully.til.service.TilService;
import com.switchfully.til.dto.CreateTilDto;
import com.switchfully.til.dto.ViewTilDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tils")
@CrossOrigin // (origins = "http://localhost:63343/")
public class TilController {
    private final TilService tilService;

    public TilController(TilService tilService) {
        this.tilService = tilService;
    }


    @GetMapping
    public List<ViewTilDto> getAllTils() {
        return tilService.getTils().stream()
                .map(til -> new ViewTilDto(til.getUuid().toString(), til.getOwner(), til.getKnowledgeOfTheDay()))
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = {"application/json"})
    public Til addTilWithPostman(@RequestBody Til newKnowledge) {
        return tilService.addTil(newKnowledge);
    }

    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    // @RequestBody does not like application/x-www-form-urlencoded information
    // Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
    public String addTilWithUI(CreateTilDto createTilDto) {
        Til til = new Til(createTilDto.getTil(), createTilDto.getOwnerName());
        tilService.addTil(til);
        System.out.println(createTilDto);
        return "Thank you " + createTilDto.getOwnerName() + ", your #TIL has been added";
    }

    @DeleteMapping("/{id}")
    public String deleteTil(@PathVariable String id) {
        return "Be gone " + id;
    }

    @PatchMapping("/{id}/like")
    // @RequestBody does not like application/x-www-form-urlencoded information
    // Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
    public String addLikeWithUI(Til newLike) {
        System.out.println(newLike.getOwner());
        return "OK";
    }
}
