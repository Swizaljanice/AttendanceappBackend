package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Attendance;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Add a new student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Mark attendance for a student
    public Attendance markAttendance(Long studentId, Attendance attendance) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            attendance.setStudent(student);
            attendance.setDate(LocalDate.parse(attendance.getDate()));  // Ensure correct date format
            return attendanceRepository.save(attendance);
        }
        return null;  // Or throw an exception if student is not found
    }
}
