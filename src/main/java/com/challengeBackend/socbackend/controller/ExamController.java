package com.challengeBackend.socbackend.controller;
import com.challengeBackend.socbackend.exception.CantDeleteMadeExamAdvice;
import com.challengeBackend.socbackend.exception.CantDeleteMadeExamException;
import com.challengeBackend.socbackend.exception.ExamNotFoundException;
import com.challengeBackend.socbackend.model.Exam;
import com.challengeBackend.socbackend.repository.ExamRepository;
import com.challengeBackend.socbackend.repository.ExamsMadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamsMadeRepository examsMadeRepository;

    @PostMapping("/exam")
    Exam newExam (@Valid @RequestBody Exam newExam){
        return examRepository.save(newExam);
    }

    @GetMapping("/allexams")
    List<Exam> getAllExams(){
        return examRepository.findAll();
    }

    @GetMapping("/exam/{id}")
    Exam getExamById(@PathVariable Long id){
        return examRepository.findById(id)
                .orElseThrow(()->new ExamNotFoundException(id));

    }

    @PutMapping("/exam/{id}")
    Exam updateExam(@Valid @RequestBody Exam newExam, @PathVariable Long id){
        return examRepository.findById(id)
                .map(exam -> {
                    exam.setExam_name(newExam.getExam_name());
                    return examRepository.save(exam);
                }).orElseThrow(() -> new ExamNotFoundException(id));
    }

    @DeleteMapping("/exam/{id}")
        String deleteExam(@PathVariable Long id){
            if(!examRepository.existsById(id)){
                throw new ExamNotFoundException(id);
            }
            if(examsMadeRepository.findExam_idInExamsMade(id) == true){
                throw new CantDeleteMadeExamException(id);

            }
            examRepository.deleteById(id);
            return "Exame com ID " + id + " foi deletado com sucesso";
    }
}
