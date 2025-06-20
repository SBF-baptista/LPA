package com.assobio.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assobio.app.model.Device;
import com.assobio.app.model.TestResult;
import com.assobio.app.repository.DeviceRepository;
import com.assobio.app.repository.TestResultRepository;

@Service
public class TestResultService {

    private final TestResultRepository testRepository;
    private final DeviceRepository deviceRepository;

    public TestResultService(TestResultRepository testRepository, DeviceRepository deviceRepository) {
        this.testRepository = testRepository;
        this.deviceRepository = deviceRepository;
    }

    public List<TestResult> findAll() {
        return testRepository.findAll();
    }

    public TestResult save(TestResult test) {
        if (test.getDevice() != null && test.getDevice().getId() != null) {
            Device device = deviceRepository.findById(test.getDevice().getId()).orElse(null);
            test.setDevice(device);
        }
        test.setTimestamp(LocalDateTime.now());
        return testRepository.save(test);
    }

    public TestResult createFromOutput(Device device, String firmwareType, String output) {
        TestResult result = new TestResult();
        result.setDevice(device);
        result.setFirmwareType(firmwareType);
        result.setFinalStatus(output.toLowerCase().contains("success") ? "SUCCESS" : "FAIL");
        return save(result);
    }
}
