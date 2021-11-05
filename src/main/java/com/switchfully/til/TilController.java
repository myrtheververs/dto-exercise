package com.switchfully.til;

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

@RestController
@RequestMapping("/tils")
@CrossOrigin // (origins = "http://localhost:63343/")
public class TilController {
    private final TilService tilService;

    public TilController(TilService tilService) {
        this.tilService = tilService;
    }


    @GetMapping
    public List<Til> getAllTils() {
        return tilService.getTils();
    }

    @PostMapping(consumes = {"application/json"})
    public Til addTilWithPostman(@RequestBody Til newKnowledge) {
        return tilService.addTil(newKnowledge);
    }

    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    // @RequestBody does not like application/x-www-form-urlencoded information
    // Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
    public String addTilWithUI(Til newKnowledge) {
        tilService.addTil(newKnowledge);
        return "Thank you " + newKnowledge.getOwner() + ", your #TIL has been added";
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
