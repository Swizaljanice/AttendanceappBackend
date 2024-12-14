package com.example.demo.repository;

import com.example.demo.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Find attendance by date
    List<Attendance> findByDate(LocalDate date);

    // Find attendance by student ID and date
    Attendance findByStudentIdAndDate(Long studentId, LocalDate date);

    // Find attendance by student ID (no date)
    List<Attendance> findByStudentId(Long studentId); // Add this line to support querying by studentId alone
}
