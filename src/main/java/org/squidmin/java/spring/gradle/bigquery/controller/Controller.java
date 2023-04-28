package org.squidmin.java.spring.gradle.bigquery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.squidmin.java.spring.gradle.bigquery.dto.Query;
import org.squidmin.java.spring.gradle.bigquery.dto.RequestExample;
import org.squidmin.java.spring.gradle.bigquery.dto.ResponseExample;
import org.squidmin.java.spring.gradle.bigquery.repository.ExampleRepositoryImpl;

import java.util.List;

@RestController
public class Controller {

    private final ExampleRepositoryImpl repository;

    public Controller(ExampleRepositoryImpl repository) {
        this.repository = repository;
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<List<ResponseExample>> findById(@RequestBody RequestExample request) {
        List<ResponseExample> response = repository.findById(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> query(@RequestBody Query query) throws JsonProcessingException {
        ResponseEntity<String> response = repository.query(query);
        return response;
    }

}