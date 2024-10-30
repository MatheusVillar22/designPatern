class Personagem {
    private String classe;
    private String arma;
    private String armadura;

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "classe='" + classe + '\'' +
                ", arma='" + arma + '\'' +
                ", armadura='" + armadura + '\'' +
                '}';
    }
}

interface PersonagemBuilder {
    void buildClasse(String classe);
    void buildArma(String arma);
    void buildArmadura(String armadura);
    Personagem getResult();
}

class GuerreiroBuilder implements PersonagemBuilder {
    private Personagem personagem = new Personagem();

    @Override
    public void buildClasse(String classe) {
        personagem.setClasse(classe);
    }

    @Override
    public void buildArma(String arma) {
        personagem.setArma(arma);
    }

    @Override
    public void buildArmadura(String armadura) {
        personagem.setArmadura(armadura);
    }

    @Override
    public Personagem getResult() {
        return personagem;
    }
}

class GameDirector {
    private PersonagemBuilder builder;

    public GameDirector(PersonagemBuilder builder) {
        this.builder = builder;
    }

    public Personagem construirPersonagem() {
        builder.buildClasse("Guerreiro");
        builder.buildArma("Espada");
        builder.buildArmadura("Armadura de Ferro");
        return builder.getResult();
    }
}

public class Main {
    public static void main(String[] args) {
        PersonagemBuilder builder = new GuerreiroBuilder();
        GameDirector diretor = new GameDirector(builder);

        Personagem guerreiro = diretor.construirPersonagem();
        System.out.println(guerreiro);
    }
}
