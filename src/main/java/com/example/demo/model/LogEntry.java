package com.example.demo.model;

import java.time.LocalDateTime;

public class LogEntry {
    private LocalDateTime timestamp;
    private String level;
    private String source;
    private String message;

    // Constructor
    public LogEntry(LocalDateTime timestamp, String level, String source, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.source = source;
        this.message = message;
    }

    // Getters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }

    // Setters
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "LogEntry{" +
                "timestamp=" + timestamp +
                ", level='" + level + '\'' +
                ", source='" + source + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
