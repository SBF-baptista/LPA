package com.assobio.app.dto;

import java.util.List;

import com.assobio.app.model.AssemblyImage;
import com.assobio.app.model.Device;
import com.assobio.app.model.TestResult;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class DeviceHistory {
    private Device device;
    private List<TestResult> tests;
    private List<AssemblyImage> images;
}
