package com.challengeBackend.socbackend.controller;
import com.challengeBackend.socbackend.model.Exam;
import com.challengeBackend.socbackend.model.ExamsMade;
import com.challengeBackend.socbackend.repository.ExamRepository;
import com.challengeBackend.socbackend.repository.ExamsMadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class ExamsMadeController {

    @Autowired
    private ExamsMadeRepository examsMadeRepository;

    @PostMapping("/examsmade")
    ExamsMade newExamsMade (@RequestBody ExamsMade newExamsMade) {
        return examsMadeRepository.save(newExamsMade);

    }


}


