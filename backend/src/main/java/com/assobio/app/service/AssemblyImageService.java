package com.assobio.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assobio.app.model.AssemblyImage;
import com.assobio.app.model.Device;
import com.assobio.app.repository.AssemblyImageRepository;
import com.assobio.app.repository.DeviceRepository;

@Service
public class AssemblyImageService {

    private final AssemblyImageRepository imageRepository;
    private final DeviceRepository deviceRepository;

    public AssemblyImageService(AssemblyImageRepository imageRepository, DeviceRepository deviceRepository) {
        this.imageRepository = imageRepository;
        this.deviceRepository = deviceRepository;
    }

    public List<AssemblyImage> findAll() {
        return imageRepository.findAll();
    }

    public List<AssemblyImage> findByDeviceId(Long deviceId) {
        return imageRepository.findByDeviceId(deviceId);
    }

    public AssemblyImage save(AssemblyImage image) {
        if (image.getDevice() != null && image.getDevice().getId() != null) {
            Device device = deviceRepository.findById(image.getDevice().getId()).orElse(null);
            image.setDevice(device);
        }
        image.setTimestamp(LocalDateTime.now());
        return imageRepository.save(image);
    }
}
