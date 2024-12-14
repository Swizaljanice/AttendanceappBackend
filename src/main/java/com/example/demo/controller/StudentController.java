package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.Attendance;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Add a new student
    @PostMapping("/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // Mark attendance for a student
    @PutMapping("/{studentId}/attendance")
    public ResponseEntity<Attendance> markAttendance(
            @PathVariable Long studentId,
            @RequestBody Attendance attendance) {

        Attendance updatedAttendance = studentService.markAttendance(studentId, attendance);
        return ResponseEntity.ok(updatedAttendance);
    }
}
