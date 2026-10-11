package br.com.matheus.gamebacklog.service;

import java.util.ArrayList;

import br.com.matheus.gamebacklog.model.Jogo;
import br.com.matheus.gamebacklog.model.StatusJogo;

public class JogoService {

    private ArrayList<Jogo> jogos;

    public JogoService() {
        jogos = new ArrayList<>();
    }

    public void adicionarJogo(Jogo novoJogo) {
        jogos.add(novoJogo);
    }

    public ArrayList<Jogo> listarJogos() {
        return jogos;
    }

    public void removeJogo(Jogo jogoRemovido) {
        jogos.remove(jogoRemovido);
    }

    public Jogo buscarPorNome(String nome) {
        for (Jogo jogoAtual : jogos) {
            if (jogoAtual.getNome().equalsIgnoreCase(nome)) {
                return jogoAtual;
            }
        }

        return null;
    }

    public boolean alterarStatus(String nome, StatusJogo novoStatus) {

        Jogo jogoEncontrado = buscarPorNome(nome);

        if (jogoEncontrado == null) {
            return false;
        }

        jogoEncontrado.setStatus(novoStatus);
        return true;
    }

    public boolean removerPorNome(String nome) {

        Jogo jogoEncontrado = buscarPorNome(nome);

        if (jogoEncontrado == null) {
            return false;
        }

        jogos.remove(jogoEncontrado);
        return true;
    }
}
