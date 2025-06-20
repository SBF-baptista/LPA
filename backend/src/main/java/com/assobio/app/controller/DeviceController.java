package com.assobio.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assobio.app.model.Device;
import com.assobio.app.repository.DeviceRepository;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping
    public List<Device> list() {
        return deviceRepository.findAll();
    }

    @PostMapping
    public Device create(@RequestBody Device device) {
        return deviceRepository.save(device);
    }
}
