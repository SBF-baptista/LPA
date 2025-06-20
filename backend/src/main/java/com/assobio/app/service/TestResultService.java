package com.assobio.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public List<TestResult> findByDeviceId(Long deviceId) {
        return testRepository.findByDeviceId(deviceId);
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
        result.setWifiResult(parseFlag(output, "wifi"));
        result.setBleResult(parseFlag(output, "ble"));
        result.setAccelerometerResult(parseFlag(output, "accelerometer"));
        result.setGnssResult(parseFlag(output, "gnss"));

        boolean success = output.toLowerCase().contains("success");
        if (Boolean.FALSE.equals(result.getWifiResult()) ||
            Boolean.FALSE.equals(result.getBleResult()) ||
            Boolean.FALSE.equals(result.getAccelerometerResult()) ||
            Boolean.FALSE.equals(result.getGnssResult())) {
            success = false;
        }
        result.setFinalStatus(success ? "SUCCESS" : "FAIL");
        return save(result);
    }

    private Boolean parseFlag(String output, String key) {
        Pattern p = Pattern.compile(key + "\s*[:=]\s*(\w+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(output);
        if (m.find()) {
            String val = m.group(1).toLowerCase();
            if (val.matches("pass|ok|success")) {
                return Boolean.TRUE;
            } else if (val.matches("fail|error")) {
                return Boolean.FALSE;
            }
        }
        return null;
    }
}
