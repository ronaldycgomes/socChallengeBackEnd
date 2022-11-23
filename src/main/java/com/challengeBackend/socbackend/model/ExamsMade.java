
package com.challengeBackend.socbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
public class ExamsMade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examsMade_id;

    private Date examsMade_date;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public Long getExamsMade_id() {
        return examsMade_id;
    }

    public void setExamsMade_id(Long examsMade_id) {
        this.examsMade_id = examsMade_id;
    }

    public Date getExamsMade_date() {
        return examsMade_date;
    }

    public void setExamsMade_date(Date examsMade_date) {
        this.examsMade_date = examsMade_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}

