package com.assobio.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assobio.app.model.AssemblyImage;
import com.assobio.app.model.Device;
import com.assobio.app.repository.AssemblyImageRepository;
import com.assobio.app.repository.DeviceRepository;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

    @Autowired
    private AssemblyImageRepository imageRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping
    public List<AssemblyImage> list() {
        return imageRepository.findAll();
    }

    @PostMapping
    public AssemblyImage create(@RequestBody AssemblyImage image) {
        if (image.getDevice() != null && image.getDevice().getId() != null) {
            Device device = deviceRepository.findById(image.getDevice().getId()).orElse(null);
            image.setDevice(device);
        }
        image.setTimestamp(LocalDateTime.now());
        return imageRepository.save(image);
    }
}
