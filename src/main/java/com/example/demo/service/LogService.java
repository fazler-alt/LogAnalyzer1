package com.example.demo.service;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.LogEntry;
import com.example.demo.utils.LogParser;

@Service
public class LogService {

    // Path to your log file inside the resources folder
    private static final String LOG_FILE_PATH = "logs/sample.log";  // Relative path inside resources

    // Method to read all logs
    public List<LogEntry> getAllLogs() {
        // Get the input stream of the log file from resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(LOG_FILE_PATH);
        
        if (inputStream == null) {
            throw new IllegalArgumentException("Log file not found: " + LOG_FILE_PATH);
        }
        
        return LogParser.parseLogFile(inputStream);  // Pass the input stream to the parser
    }

    // Method to filter logs by level
    public List<LogEntry> getLogsByLevel(String level) {
        return getAllLogs().stream()
                .filter(log -> log.getLevel().equalsIgnoreCase(level))
                .collect(Collectors.toList());
    }
}
