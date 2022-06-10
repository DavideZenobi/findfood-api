package io.spring.demo.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.demo.models.Label;
import io.spring.demo.services.LabelService;

@RestController
@RequestMapping(path = "/api/label")
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Label> getAll() {
        return labelService.findAll();
    }
    
}
