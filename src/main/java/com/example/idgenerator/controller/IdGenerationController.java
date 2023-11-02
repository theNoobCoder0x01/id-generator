package com.example.idgenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.idgenerator.service.IdGenerationService;

@RestController
@RequestMapping("/new-id")
public class IdGenerationController {
    @GetMapping
    public String getNextId() {
        // return IdGenerationService.nextId();
        return "{\"id\": \"" + Long.toString(IdGenerationService.nextId()) + "\"}";
    }
}
