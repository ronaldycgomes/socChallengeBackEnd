package com.challengeBackend.socbackend.exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Long id){
        super("Não foi possível achar um funcionário com o ID " + id);
    }
}
