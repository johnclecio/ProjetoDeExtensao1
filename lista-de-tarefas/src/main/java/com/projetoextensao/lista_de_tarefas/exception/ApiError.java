package com.projetoextensao.lista_de_tarefas.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiError {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private Map<String, String> details;


    public ApiError(int status, String error, Map<String, String> details) {
        this(status, error, details, LocalDateTime.now());
    }

    public ApiError(int status, String error, Map<String, String> details, LocalDateTime timestamp) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.details = details;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public Map<String, String> getDetails() {
        return details;
    }
}
