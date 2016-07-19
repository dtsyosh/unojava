package modelo;

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
        
        while(true){    //Garante que a primeira carta será sempre um número
            if(this.baralho.getCartas().get(this.baralho.getCartas().size()-1) instanceof CartaNumero){
                colocaNoTopoMonte(this.baralho.darCarta());
                break;
            }else
                this.baralho.adicionarCartas(this.baralho.darCarta());
        }
    }
    
    public boolean validarJogada(Carta cartaMao, Carta topo){
        if(cartaMao.getCor().equals(topo.getCor()))
            return true;
        else
            if(topo instanceof CartaNumero){
                if(cartaMao instanceof CartaNumero)
                    if(((CartaNumero) cartaMao).getNumero() == ((CartaNumero)topo).getNumero())
                        return true;
               
            }
        return false;
    }
}
