package com.assobio.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
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
}
