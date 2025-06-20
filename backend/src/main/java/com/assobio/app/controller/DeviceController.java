package com.assobio.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assobio.app.model.Device;
import com.assobio.app.service.DeviceService;
import com.assobio.app.service.TestResultService;
import com.assobio.app.service.AssemblyImageService;
import com.assobio.app.dto.DeviceHistory;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin
public class DeviceController {

    private final DeviceService deviceService;
    private final TestResultService testService;
    private final AssemblyImageService imageService;

    public DeviceController(DeviceService deviceService,
                            TestResultService testService,
                            AssemblyImageService imageService) {
        this.deviceService = deviceService;
        this.testService = testService;
        this.imageService = imageService;
    }

    @GetMapping
    public List<Device> list() {
        return deviceService.findAll();
    }

    @GetMapping("/{serial}")
    public Device getBySerial(@PathVariable String serial) {
        return deviceService.findBySerial(serial);
    }

    @PostMapping
    public Device create(@RequestBody Device device) {
        return deviceService.save(device);
    }

    @GetMapping("/{serial}/history")
    public DeviceHistory getHistory(@PathVariable String serial) {
        Device device = deviceService.findBySerial(serial);
        if (device == null) {
            return null;
        }
        return new DeviceHistory(
            device,
            testService.findByDeviceId(device.getId()),
            imageService.findByDeviceId(device.getId())
        );
    }
}
