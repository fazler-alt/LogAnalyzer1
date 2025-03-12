package com.example.demo.controller;

import com.example.demo.model.LogEntry;
import com.example.demo.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<LogEntry> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/{level}")
    public List<LogEntry> getLogsByLevel(@PathVariable String level) {
        return logService.getLogsByLevel(level);
    }
}
