package com.challengeBackend.socbackend.exception;

public class ExamNotFoundException extends RuntimeException {
    public ExamNotFoundException(Long id){
        super("Não foi possível achar um exame com o ID " + id);
    }
}
