package com.assobio.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assobio.app.model.Device;
import com.assobio.app.model.TestResult;
import com.assobio.app.service.DeviceService;
import com.assobio.app.service.FirmwareService;
import com.assobio.app.service.TestResultService;

@RestController
@RequestMapping("/api/firmware")
@CrossOrigin
public class FirmwareController {

    private final FirmwareService firmwareService;
    private final TestResultService testService;
    private final DeviceService deviceService;

    public FirmwareController(FirmwareService firmwareService,
                              TestResultService testService,
                              DeviceService deviceService) {
        this.firmwareService = firmwareService;
        this.testService = testService;
        this.deviceService = deviceService;
    }

    @PostMapping("/run")
    public TestResult run(@RequestParam String serialNumber,
                          @RequestParam String firmwareCommand) {
        Device device = deviceService.findOrCreateBySerial(serialNumber);
        String output = firmwareService.runFirmware(firmwareCommand);
        TestResult result = testService.createFromOutput(device, firmwareCommand, output);
        return result;
    }
}
