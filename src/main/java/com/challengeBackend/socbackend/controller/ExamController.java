package com.challengeBackend.socbackend.controller;
import com.challengeBackend.socbackend.exception.ExamNotFoundException;
import com.challengeBackend.socbackend.model.Exam;
import com.challengeBackend.socbackend.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

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
            examRepository.deleteById(id);
            return "Exame com ID " + id + " foi deletado com sucesso";
    }
}
