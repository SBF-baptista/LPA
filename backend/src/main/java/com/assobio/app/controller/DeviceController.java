package com.assobio.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assobio.app.model.Device;
import com.assobio.app.service.DeviceService;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> list() {
        return deviceService.findAll();
    }

    @PostMapping
    public Device create(@RequestBody Device device) {
        return deviceService.save(device);
    }
}
