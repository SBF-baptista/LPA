package com.assobio.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assobio.app.model.AssemblyImage;
import com.assobio.app.service.AssemblyImageService;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

    private final AssemblyImageService imageService;

    public ImageController(AssemblyImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<AssemblyImage> list() {
        return imageService.findAll();
    }

    @PostMapping
    public AssemblyImage create(@RequestBody AssemblyImage image) {
        return imageService.save(image);
    }
}
