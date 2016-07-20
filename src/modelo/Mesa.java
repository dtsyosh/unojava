package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mesa {

    private Baralho baralho;
    private Stack<Carta> monteCarta;

    public Mesa(Baralho baralho) {
        this.baralho = baralho;
        this.monteCarta = new Stack();
    }

    public Baralho getBaralho() {	//retorna o baralho
        return this.baralho;
    }

    public Carta verTopoMonte() {	//retorna a o topo do monte
        return this.monteCarta.peek();
    }

    public void colocaNoTopoMonte(Carta carta) {	//função para que pega o descarte do jogador
        this.monteCarta.push(carta);
    }

    public void iniciarNovoJogo(Jogador jogador1, Jogador jogador2) {
        this.baralho.embaralhar();
        for (int i = 0; i < 7; i++) {
            jogador1.comprarCarta();
            jogador2.comprarCarta();
        }

        while (true) {    //Garante que a primeira carta será sempre um número
            if (this.baralho.getCartas().get(this.baralho.getCartas().size() - 1) instanceof CartaNumero) {
                colocaNoTopoMonte(this.baralho.darCarta());
                break;
            } else {
                this.baralho.adicionarCartas(this.baralho.darCarta());
            }
        }
    }

    public boolean validarJogada(Carta cartaMao, Carta topo, List<Carta> mao) {
        if (cartaMao instanceof CartaEspecial) {
            if (((CartaEspecial) cartaMao).getEspecial().equals("+4")) { //Se for um +4 tem que ver se é a única opção
                for (int i = 0; i < mao.size(); i++) {
                    if (mao.get(i) instanceof CartaEspecial) {   //Se houver um coringa,, ja bloqueia a jogada
                        if (((CartaEspecial) cartaMao).getEspecial().equals("Troca Cor")) {
                            return false;
                        } else if (mao.get(i).getCor().equals(topo.getCor())) {
                            return false;
                        } else if (mao.get(i) instanceof CartaNumero) {
                            if (mao.get(i) instanceof CartaNumero) {
                                if (((CartaNumero) cartaMao).getNumero() == ((CartaNumero) topo).getNumero()) {
                                    return false;
                                }
                            }

                        } else if (mao.get(i) instanceof CartaSimbolo) {
                            if (mao.get(i) instanceof CartaSimbolo) {
                                if (((CartaSimbolo) cartaMao).getSimbolo().equals(((CartaSimbolo) topo).getSimbolo())) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                return true;
            }else   //Se for um coringa, ta tudo liberado;
                return true;
        }
        if (cartaMao.getCor().equals(topo.getCor())) {
            return true;
        } else if (topo instanceof CartaNumero) {
            if (cartaMao instanceof CartaNumero) {
                if (((CartaNumero) cartaMao).getNumero() == ((CartaNumero) topo).getNumero()) {
                    return true;
                }
            }

        } else if (topo instanceof CartaSimbolo) {
            if (cartaMao instanceof CartaSimbolo) {
                if (((CartaSimbolo) cartaMao).getSimbolo().equals(((CartaSimbolo) topo).getSimbolo())) {
                    return true;
                }
            }
        }

        return false;
    }

    public Stack<Carta> getMonteCarta() {
        return this.monteCarta;
    }
}
