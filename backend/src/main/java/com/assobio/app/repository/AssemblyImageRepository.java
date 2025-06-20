package com.assobio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assobio.app.model.AssemblyImage;

public interface AssemblyImageRepository extends JpaRepository<AssemblyImage, Long> {
}
