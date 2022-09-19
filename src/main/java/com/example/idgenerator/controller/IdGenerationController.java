package com.example.idgenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.idgenerator.service.IdGenerationService;

@RestController
@RequestMapping("/newId")
public class IdGenerationController {
    @GetMapping
    public Long getNextId() {
        return IdGenerationService.nextId();
        // return Long.toBinaryString(IdGenerationService.nextId());
    }
}
