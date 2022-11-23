package com.challengeBackend.socbackend.controller;
import com.challengeBackend.socbackend.exception.CantDeleteMadeExamException;
import com.challengeBackend.socbackend.exception.ExamNotFoundException;
import com.challengeBackend.socbackend.exception.ExamsMadeAlreadyExistsException;
import com.challengeBackend.socbackend.exception.ExamsMadeNotFoundException;
import com.challengeBackend.socbackend.model.Exam;
import com.challengeBackend.socbackend.model.ExamsMade;
import com.challengeBackend.socbackend.repository.ExamRepository;
import com.challengeBackend.socbackend.repository.ExamsMadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class ExamsMadeController {

    @Autowired
    private ExamsMadeRepository examsMadeRepository;


    @PostMapping("/examsmade")
    ExamsMade newExamsMade (@RequestBody ExamsMade newExamsMade) {
        Date examsMade_date = newExamsMade.getExamsMade_date();
        long examId = newExamsMade.getExam().getExam_id();
        long employeeId = newExamsMade.getEmployee().getEmployee_id();
        if(examsMadeRepository.FindExamsMadeByAllFields(examId, employeeId, examsMade_date)){
            throw new ExamsMadeAlreadyExistsException();
        }
        return examsMadeRepository.save(newExamsMade);
    }

    @GetMapping("/allexamsmade")
    List<ExamsMade> getAllExamsMade(){
        return examsMadeRepository.findAll();
    }

    @GetMapping("/examsmade/{id}")
    ExamsMade getExamsMadeById(@PathVariable Long id){
        return examsMadeRepository.findById(id)
                .orElseThrow(()->new ExamsMadeNotFoundException(id));

    }


    @PutMapping("/examsMade/{id}")
    ExamsMade updateExamsMade(@Valid @RequestBody ExamsMade newExamsMade, @PathVariable Long id){
        return examsMadeRepository.findById(id)
                .map(examsMade -> {
                    examsMade.setExamsMade_date(newExamsMade.getExamsMade_date());
                    examsMade.setExam(newExamsMade.getExam());
                    examsMade.setEmployee(newExamsMade.getEmployee());
                    return examsMadeRepository.save(examsMade);
                }).orElseThrow(() -> new ExamsMadeNotFoundException(id));
    }



    @DeleteMapping("/examsMade/{id}")
    String deleteExamsMade(@PathVariable Long id){
        if(!examsMadeRepository.existsById(id)){
            throw new ExamsMadeNotFoundException(id);
        }
        examsMadeRepository.deleteById(id);
        return "Exame realizado com ID " + id + " foi deletado com sucesso";
    }
}


