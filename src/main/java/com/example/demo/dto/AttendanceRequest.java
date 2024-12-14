package com.example.demo.dto;

public class AttendanceRequest {

    private Long studentId;
    private String date;  // Date in string format (yyyy-MM-dd)
    private String status; // "Present" or "Absent"

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
