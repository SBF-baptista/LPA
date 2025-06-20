package com.assobio.app.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class FirmwareService {

    public String runFirmware(String command) {
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            String output = new BufferedReader(
                new InputStreamReader(process.getInputStream()))
                .lines()
                .collect(Collectors.joining("\n"));
            process.waitFor(60, TimeUnit.SECONDS);
            return output;
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to run firmware", e);
        }
    }
}
