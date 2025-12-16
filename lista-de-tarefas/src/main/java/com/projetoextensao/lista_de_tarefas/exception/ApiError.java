package com.projetoextensao.lista_de_tarefas.exception;

public class ApiError {

    private String campo;
    private String mensagem;


    public ApiError(String campo, String mensagem){
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
