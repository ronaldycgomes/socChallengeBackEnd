package com.challengeBackend.socbackend.exception;

public class ExamsMadeAlreadyExistsException extends RuntimeException {
    public ExamsMadeAlreadyExistsException(){
        super("Já existe um exame realizado com a mesma data, funcionário e tipo de exame. Não foi possível concluir esse cadastro! ");
    }
}
