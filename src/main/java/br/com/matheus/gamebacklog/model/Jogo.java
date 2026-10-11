package br.com.matheus.gamebacklog.model;

public class Jogo {

    private String nome;
    private StatusJogo status;
    private String plataforma;

    public Jogo(String nome, StatusJogo status, String plataforma) {
        this.nome = nome;
        this.status = status;
        this.plataforma = plataforma;
    }

    public String getNome() {
        return nome;
    }

    public StatusJogo getStatus() {
        return status;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setStatus(StatusJogo status) {
        this.status = status;
    }
}
