package com.thecodeschool.springrest.controller;

import com.thecodeschool.springrest.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<Student>();

    @RequestMapping()
    public List<Student> getStudentDetails() {

        return students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(name ="id") long id) {
        Optional<Student> student = students.stream().filter(e -> e.getId() == id).findFirst();


        return student.get();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(name ="id") long id) {
        Optional<Student> student = students.stream().filter(e -> e.getId() == id).findFirst();

        if (student.isEmpty()) {
            return "Student with id " + id + " is not found.";
        }
        System.out.println(student.get());
        students.remove(student.get());
        System.out.println(students);
        return "Student with Id " + id + " is deleted;";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        Optional<Student> studentFound = students.stream().filter(e -> e.getId() == student.getId()).findFirst();

        if (studentFound.isEmpty()) {
            return "Student with id " + student.getId() + " is not found.";
        }
        System.out.println(studentFound.get());
        students.remove(studentFound.get());
        students.add(student);
        System.out.println(students);
        return "Student with Id " + student.getId() + " is updated;";
    }

    @PostMapping
    public List<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        return students;
    }
}
