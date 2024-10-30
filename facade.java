class Conexao {
    void conectar() {
        System.out.println("Conectando ao servidor de jogo...");
    }

    void autenticar(String jogador) {
        System.out.println("Autenticando jogador " + jogador + "...");
    }
}

class Inventario {
    void carregarInventario(String jogador) {
        System.out.println("Carregando inventário para o jogador " + jogador + "...");
    }
}

class Combate {
    void prepararCombate() {
        System.out.println("Preparando jogador para combate...");
    }
}

class JogoFacade {
    private final Conexao conexao;
    private final Inventario inventario;
    private final Combate combate;

    public JogoFacade() {
        this.conexao = new Conexao();
        this.inventario = new Inventario();
        this.combate = new Combate();
    }

    public void iniciarJogo(String jogador) {
        conexao.conectar();
        conexao.autenticar(jogador);
        inventario.carregarInventario(jogador);
        combate.prepararCombate();
        System.out.println("Jogo iniciado para o jogador: " + jogador);
    }
}

public class Main {
    public static void main(String[] args) {
        JogoFacade jogo = new JogoFacade();
        jogo.iniciarJogo("Jogador1");
    }
}
