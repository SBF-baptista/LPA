package com.assobio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assobio.app.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findBySerialNumber(String serialNumber);
}
