package com.challengeBackend.socbackend.exception;

public class CantDeleteMadeExamException extends RuntimeException {
    public CantDeleteMadeExamException(Long id){
        super("Não foi possível deletar o exame realizado ID " + id + ", pois existem registros deste exame em 'Exames realizados' ");
    }
}
