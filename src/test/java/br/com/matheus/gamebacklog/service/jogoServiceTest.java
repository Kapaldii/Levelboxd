package br.com.matheus.gamebacklog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import br.com.matheus.gamebacklog.model.Jogo;
import br.com.matheus.gamebacklog.model.StatusJogo;

public class jogoServiceTest {

    @Test
    void naoDeveRemoverJogoInexistente() {

        JogoService service = new JogoService();

        boolean resultado = service.removerPorNome("Minecraft");

        assertFalse(resultado);
    }

    @Test
    void deveCadastrarJogoNaLista(){

        JogoService service = new JogoService();

        Jogo novoJogo = new Jogo("Minecraft", StatusJogo.QUERO_JOGAR,"PC");
        
        service.adicionarJogo(novoJogo);
        assertEquals(1, service.listarJogos().size());
    }

    @Test
    void deveBuscarJogoPorNome(){
          
        JogoService service = new JogoService();
        Jogo novoJogo = new Jogo("Minecraft", StatusJogo.QUERO_JOGAR,"PC");

        service.adicionarJogo(novoJogo);

        Jogo novoJogo1 = new Jogo("God Of War", StatusJogo.QUERO_JOGAR,"PC");
        service.adicionarJogo(novoJogo1);

         Jogo buscar = service.buscarPorNome("god of war");

        assertEquals("God Of War", buscar.getNome());

    }

}
