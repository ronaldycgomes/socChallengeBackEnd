package com.challengeBackend.socbackend.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exam_id;

    @NotEmpty(message = "Nome do exame é obrigatório")
    @NotNull(message = "Nome do exame é obrigatório")
    private String exam_name;

    @OneToMany(mappedBy = "exam")
    Set<ExamsMade> examMade;


    public Long getExam_id() {
        return exam_id;
    }

    public void setExam_id(Long exam_id) {
        this.exam_id = exam_id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public Set<ExamsMade> getExamMade() {
        return examMade;
    }

    public void setExamMade(Set<ExamsMade> examMade) {
        this.examMade = examMade;
    }
}
