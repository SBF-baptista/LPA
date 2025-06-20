package com.assobio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.assobio.app.model.AssemblyImage;

public interface AssemblyImageRepository extends JpaRepository<AssemblyImage, Long> {
    List<AssemblyImage> findByDeviceId(Long deviceId);
}
