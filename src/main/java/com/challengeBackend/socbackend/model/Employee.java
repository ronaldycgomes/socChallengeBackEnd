package com.challengeBackend.socbackend.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @NotEmpty(message = "Nome do funcionário é obrigatório")
    @NotNull(message = "Nome do funcionário é obrigatório")
    private String employee_name;
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    Set<ExamsMade> examMade;


    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Set<ExamsMade> getExamMade() {
        return examMade;
    }

    public void setExamMade(Set<ExamsMade> examMade) {
        this.examMade = examMade;
    }
}
