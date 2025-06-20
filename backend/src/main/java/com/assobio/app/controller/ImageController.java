package com.assobio.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assobio.app.model.AssemblyImage;
import com.assobio.app.model.Device;
import com.assobio.app.service.AssemblyImageService;
import com.assobio.app.service.DeviceService;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

    private final AssemblyImageService imageService;
    private final DeviceService deviceService;

    public ImageController(AssemblyImageService imageService, DeviceService deviceService) {
        this.imageService = imageService;
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<AssemblyImage> list() {
        return imageService.findAll();
    }

    @PostMapping
    public AssemblyImage create(@RequestBody AssemblyImage image) {
        return imageService.save(image);
    }

    @PostMapping("/upload")
    public AssemblyImage upload(@RequestParam Long deviceId,
                                @RequestParam String step,
                                @RequestParam MultipartFile file,
                                @RequestParam(required = false) String comment) throws IOException {
        Device device = deviceService.findById(deviceId);
        String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
        Path uploadDir = Paths.get("uploads");
        Files.createDirectories(uploadDir);
        Path destination = uploadDir.resolve(filename);
        Files.write(destination, file.getBytes());

        AssemblyImage image = new AssemblyImage();
        image.setDevice(device);
        image.setStep(step);
        image.setImageUrl(destination.toString());
        image.setComment(comment);
        return imageService.save(image);
    }
}
