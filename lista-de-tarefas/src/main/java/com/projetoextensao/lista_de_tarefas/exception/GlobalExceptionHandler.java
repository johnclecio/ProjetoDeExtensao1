package com.projetoextensao.lista_de_tarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ApiError>> tratarValidacoes(MethodArgumentNotValidException ex) {

        List<ApiError> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new ApiError(
                        erro.getField(),
                        erro.getDefaultMessage()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
}
