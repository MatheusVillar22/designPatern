import java.util.ArrayList;
import java.util.List;

interface Observer {
    void atualizar(String mensagem);
}

class Jogo {
    private List<Observer> jogadores = new ArrayList<>();
    private String estado;

    void adicionarJogador(Observer jogador) {
        jogadores.add(jogador);
    }

    void removerJogador(Observer jogador) {
        jogadores.remove(jogador);
    }

    void setEstado(String novoEstado) {
        this.estado = novoEstado;
        notificarJogadores();
    }

    private void notificarJogadores() {
        for (Observer jogador : jogadores) {
            jogador.atualizar(estado);
        }
    }

    void eventoImportante(String evento) {
        setEstado(evento);
    }
}

class Jogador implements Observer {
    private String nome;

    Jogador(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu a mensagem: " + mensagem);
    }
}

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        Jogador jogador1 = new Jogador("Jogador 1");
        Jogador jogador2 = new Jogador("Jogador 2");

        jogo.adicionarJogador(jogador1);
        jogo.adicionarJogador(jogador2);

        jogo.eventoImportante("Um novo jogador entrou na partida!");
        jogo.eventoImportante("Um boss foi derrotado!");
        jogo.eventoImportante("Um item raro foi encontrado!");
    }
}
