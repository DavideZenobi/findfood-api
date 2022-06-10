package io.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.spring.demo.models.Label;

public interface LabelRepository extends JpaRepository<Label, String> {
    
    public List<Label> findAll();

}
