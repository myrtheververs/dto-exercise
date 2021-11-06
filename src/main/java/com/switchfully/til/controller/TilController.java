package com.switchfully.til.controller;

import com.switchfully.til.domain.Til;
import com.switchfully.til.service.TilService;
import com.switchfully.til.dto.CreateTilDto;
import com.switchfully.til.dto.ViewTilDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(TilController.class);

    public TilController(TilService tilService) {
        this.tilService = tilService;
    }


//OK
    @GetMapping
    public List<ViewTilDto> getAllTils() {
        return tilService.getTils();
    }

//OK
    @PostMapping(consumes = {"application/json"})
    public Til addTilWithPostman(@RequestBody CreateTilDto createTilDto) {
        return tilService.addTil(createTilDto);
    }


//OK
    // @RequestBody does not like application/x-www-form-urlencoded information
    // Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    public String addTilWithUI(CreateTilDto createTilDto) {
        logger.info("Creating til...");
        tilService.addTil(createTilDto);
        System.out.println(createTilDto);
        return "Thank you " + createTilDto.getOwnerName() + ", your #TIL has been added";
    }

//OK
    @DeleteMapping("/{id}")
    public String deleteTil(@PathVariable String id) {
        logger.info("Removing til...");
        tilService.removeTil(id);
        return "Be gone " + id;
    }


//v???
    // @RequestBody does not like application/x-www-form-urlencoded information
    // Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
    @PatchMapping("/{id}/like")
    public String addLikeWithUI(Til newLike) {
        System.out.println(newLike.getOwner());
        return "OK";
    }
}
