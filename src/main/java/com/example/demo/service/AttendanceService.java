package com.example.demo.service;

import com.example.demo.model.Attendance;
import com.example.demo.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Fetch attendance records for a specific date
    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    // Mark attendance for a student
    public Attendance markAttendance(Long studentId, LocalDate date, String status) {
        Attendance attendance = new Attendance();
        attendance.setStudentId(studentId); // Set student ID (assuming it's already present)
        attendance.setDate(date);
        attendance.setStatus(status);

        return attendanceRepository.save(attendance); // Save the attendance record
    }
}
