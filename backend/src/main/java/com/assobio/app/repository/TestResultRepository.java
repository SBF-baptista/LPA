package com.assobio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assobio.app.model.TestResult;
import java.util.List;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    List<TestResult> findByDeviceId(Long deviceId);
}
