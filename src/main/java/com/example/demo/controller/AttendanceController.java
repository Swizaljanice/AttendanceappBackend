package com.example.demo.controller;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.model.Attendance;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentService studentService;

    // Get attendance by date
    @GetMapping("/{date}")
    public List<Attendance> getAttendanceByDate(@PathVariable String date) {
        // Convert string to LocalDate for comparison
        LocalDate localDate = LocalDate.parse(date);
        // Fetch attendance records for the given date
        return attendanceService.getAttendanceByDate(localDate);
    }

    // Mark attendance for a student
    @PostMapping("/mark")
    public ResponseEntity<Attendance> markAttendance(@RequestBody AttendanceRequest attendanceRequest) {
        // Convert the date string into LocalDate
        LocalDate localDate = LocalDate.parse(attendanceRequest.getDate());

        // Call the service to mark attendance
        Attendance updatedAttendance = attendanceService.markAttendance(
                attendanceRequest.getStudentId(),
                localDate,
                attendanceRequest.getStatus()
        );

        return ResponseEntity.ok(updatedAttendance); // Return the updated attendance record
    }
}
