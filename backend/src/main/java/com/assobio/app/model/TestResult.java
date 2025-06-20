package com.assobio.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Device device;

    private String firmwareType;
    private Boolean wifiResult;
    private Boolean bleResult;
    private Boolean accelerometerResult;
    private Boolean gnssResult;

    private LocalDateTime timestamp;

    private String finalStatus;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getFirmwareType() {
        return firmwareType;
    }

    public void setFirmwareType(String firmwareType) {
        this.firmwareType = firmwareType;
    }

    public Boolean getWifiResult() {
        return wifiResult;
    }

    public void setWifiResult(Boolean wifiResult) {
        this.wifiResult = wifiResult;
    }

    public Boolean getBleResult() {
        return bleResult;
    }

    public void setBleResult(Boolean bleResult) {
        this.bleResult = bleResult;
    }

    public Boolean getAccelerometerResult() {
        return accelerometerResult;
    }

    public void setAccelerometerResult(Boolean accelerometerResult) {
        this.accelerometerResult = accelerometerResult;
    }

    public Boolean getGnssResult() {
        return gnssResult;
    }

    public void setGnssResult(Boolean gnssResult) {
        this.gnssResult = gnssResult;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }
}
