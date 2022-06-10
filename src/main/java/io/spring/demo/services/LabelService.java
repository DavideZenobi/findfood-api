package io.spring.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.demo.models.Label;
import io.spring.demo.repositories.LabelRepository;

@Service
public class LabelService {
    
    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<Label> findAll() {
        return labelRepository.findAll();
    }

}
