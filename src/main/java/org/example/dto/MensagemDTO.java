package org.example.dto;

public class MensagemDTO {
    public String remetente;
    public String conteudo;

    public MensagemDTO() {
    }

    public String getRemetente() {        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}


