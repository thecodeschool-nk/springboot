package com.thecodeschool.webclient.model;

import reactor.core.publisher.Mono;

import java.util.Map;

public class Report {
    private long studentId;
    private Mono<Student> studentMono;
    private Map<String, Integer> marks;

    public Report(long studentId, Mono<Student> studentMono, Map<String, Integer> marks) {
        this.studentId = studentId;
        this.studentMono = studentMono;
        this.marks = marks;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public Mono<Student> getStudentMono() {
        return studentMono;
    }

    public void setStudentMono(Mono<Student> studentMono) {
        this.studentMono = studentMono;
    }
}
