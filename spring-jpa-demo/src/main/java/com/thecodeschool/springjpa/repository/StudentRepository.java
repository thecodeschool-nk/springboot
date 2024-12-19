package com.thecodeschool.springjpa.repository;

import com.thecodeschool.springjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
