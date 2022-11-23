package com.challengeBackend.socbackend.exception;

public class ExamsMadeNotFoundException extends RuntimeException{
    public ExamsMadeNotFoundException(Long id){
        super("Não foi possível achar um exame realizado com o ID " + id);
}
    }
