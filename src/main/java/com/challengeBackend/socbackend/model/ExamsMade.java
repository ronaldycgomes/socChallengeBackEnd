
package com.challengeBackend.socbackend.model;

import javax.persistence.*;


@Entity
public class ExamsMade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examsMade_id;

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

