package modelo;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    String nome;
    List<Carta> mao;
    Mesa mesa;

    public Jogador(String nome, Mesa mesa) {
        this.nome = nome;
        this.mao = new ArrayList();
        this.mesa = mesa;
    }

    public void comprarCarta() {
        this.mao.add(mesa.getBaralho().darCarta());
    }

    public Carta jogarCarta(int indice) {
        return this.mao.remove(indice);
    }

    public String getNome() {
        return this.nome;
    }

    public List<Carta> getMao() {
        return this.mao;
    }

}
