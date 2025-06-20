package com.assobio.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assobio.app.model.Device;
import com.assobio.app.repository.DeviceRepository;

@Service
public class DeviceService {

    private final DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public List<Device> findAll() {
        return repository.findAll();
    }

    public Device save(Device device) {
        return repository.save(device);
    }

    public Device findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Device findBySerial(String serial) {
        return repository.findBySerialNumber(serial);
    }

    public Device findOrCreateBySerial(String serial) {
        Device device = repository.findBySerialNumber(serial);
        if (device == null) {
            device = new Device();
            device.setSerialNumber(serial);
            device = repository.save(device);
        }
        return device;
    }
}
