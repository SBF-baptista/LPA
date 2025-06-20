package com.assobio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assobio.app.model.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}
