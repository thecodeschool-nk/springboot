package com.thecodeschool.springjpa.resource;

import com.thecodeschool.springjpa.entity.Student;
import com.thecodeschool.springjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/students")
public class StudentResource {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public Iterable<Student> getStudentDetails() {

        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(name ="id") long id) {

        return studentRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(name ="id") long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isEmpty()) {
            return "Student with id " + id + " is not found.";
        }
        System.out.println(student.get());
        studentRepository.delete(student.get());
        return "Student with Id " + id + " is deleted;";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        Optional<Student> studentFound = studentRepository.findById(student.getId());

        if (studentFound.isEmpty()) {
            return "Student with id " + student.getId() + " is not found.";
        }
        System.out.println(studentFound.get());
//        studentRepository.delete(studentFound.get());
        studentRepository.save(student);
        return "Student with Id " + student.getId() + " is updated;";
    }

    @PostMapping
    public Iterable<Student> addStudent(@RequestBody Student student) {

        studentRepository.save(student);
        return studentRepository.findAll();
    }
}
