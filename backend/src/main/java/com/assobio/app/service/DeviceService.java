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
}
