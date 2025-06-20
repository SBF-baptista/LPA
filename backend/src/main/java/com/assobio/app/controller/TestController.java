package com.assobio.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assobio.app.model.TestResult;
import com.assobio.app.service.TestResultService;

@RestController
@RequestMapping("/api/tests")
@CrossOrigin
public class TestController {

    private final TestResultService testService;

    public TestController(TestResultService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<TestResult> list() {
        return testService.findAll();
    }

    @PostMapping
    public TestResult create(@RequestBody TestResult test) {
        return testService.save(test);
    }
}
