package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.model.LogEntry;

public class LogParser {

    private static final Pattern LOG_PATTERN = Pattern.compile(
        "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}) (INFO|WARNING|ERROR|CRITICAL) (\\S+) - (.+)"
    );

    // Parse log file using InputStream
    public static List<LogEntry> parseLogFile(InputStream inputStream) {
        List<LogEntry> logs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = LOG_PATTERN.matcher(line);
                if (matcher.matches()) {
                    logs.add(new LogEntry(
                        LocalDateTime.parse(matcher.group(1).replace(" ", "T")),
                        matcher.group(2),
                        matcher.group(3),
                        matcher.group(4)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logs;
    }
}
