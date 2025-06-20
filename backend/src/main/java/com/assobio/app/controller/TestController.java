package com.assobio.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assobio.app.model.Device;
import com.assobio.app.model.TestResult;
import com.assobio.app.repository.DeviceRepository;
import com.assobio.app.repository.TestResultRepository;

@RestController
@RequestMapping("/api/tests")
@CrossOrigin
public class TestController {

    @Autowired
    private TestResultRepository testRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping
    public List<TestResult> list() {
        return testRepository.findAll();
    }

    @PostMapping
    public TestResult create(@RequestBody TestResult test) {
        if (test.getDevice() != null && test.getDevice().getId() != null) {
            Device device = deviceRepository.findById(test.getDevice().getId()).orElse(null);
            test.setDevice(device);
        }
        test.setTimestamp(LocalDateTime.now());
        return testRepository.save(test);
    }
}
