/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author yosh
 */
public class JogadorIA extends Jogador {

    public JogadorIA(String nome, Mesa mesa) {
        super(nome, mesa);
    }

    public void realizarJogada(Carta cartaTopoMonte) {     // <-- mesa.verTopoMonte()

        if ((cartaTopoMonte instanceof CartaSimbolo) && (((CartaSimbolo) cartaTopoMonte).getEfeito() == 1)) {
            if (cartaTopoMonte instanceof CartaSimbolo) {
                if (!((CartaSimbolo) cartaTopoMonte).getSimbolo().equals("+2")) { //Se não for +2
                    ((CartaSimbolo) mesa.verTopoMonte()).desativarEfeito();
                    return;
                } else {
                    this.comprarCarta();
                    this.comprarCarta();
                    ((CartaSimbolo) mesa.verTopoMonte()).desativarEfeito();
                    return;
                }
            }
        }

        if ((cartaTopoMonte instanceof CartaEspecial) && (((CartaEspecial) cartaTopoMonte).getEfeito() == 1
                && ((CartaEspecial) cartaTopoMonte).getEspecial().equals("+4"))) {
            this.comprarCarta();
            this.comprarCarta();
            this.comprarCarta();
            this.comprarCarta();
            ((CartaEspecial) mesa.verTopoMonte()).desativarEfeito();
            return;
        }

        ArrayList<Carta> cartasPossiveis = new ArrayList(); //Vetor que guarda todas as cartas possiveis de serem jogadas
        Carta cartaJogada = null;
        Carta cartaAtual;

        Integer[] quantidadeCores = {0, 0, 0, 0, 0}; //1 Vermelho, 2 Azul, 3 Amarelo, 4 Verde
        String[] cores = {"", "Vermelho", "Azul", "Amarelo", "Verde"};

        //Percorre a mão procurando cartas que podem ser jogadas           
        for (int i = 0; i < this.mao.size(); i++) {
            cartaAtual = this.mao.get(i);

            if (cartaAtual.getCor().equals(cartaTopoMonte.getCor())) {    //Verifica pela cor, serve para Simbolo/Numero de cores iguais
                cartasPossiveis.add(cartaAtual);

                switch (cartaAtual.getCor()) {       //Incrementa o vetor de quantidade de cartas
                    case "Vermelho":
                        quantidadeCores[1]++;
                        break;
                    case "Azul":
                        quantidadeCores[2]++;
                        break;
                    case "Amarelo":
                        quantidadeCores[3]++;
                        break;
                    case "Verde":
                        quantidadeCores[4]++;
                        break;
                    default:
                        break;
                }

                this.mao.remove(i);
                --i; //Para não pular 1 posição no vetor apos a remoção
            } else if (cartaAtual instanceof CartaNumero && cartaTopoMonte instanceof CartaNumero) { //Verifica se a carta é do tipo CartaNumero
                if (((CartaNumero) cartaAtual).getNumero() == ((CartaNumero) cartaTopoMonte).getNumero()) { //Pega os números possiveis só que de cores diferentes
                    cartasPossiveis.add(cartaAtual);
                    switch (cartaAtual.getCor()) {       //Incrementa o vetor de quantidade de cartas
                        case "Vermelho":
                            quantidadeCores[1]++;
                            break;
                        case "Azul":
                            quantidadeCores[2]++;
                            break;
                        case "Amarelo":
                            quantidadeCores[3]++;
                            break;
                        case "Verde":
                            quantidadeCores[4]++;
                            break;
                        default:
                            break;
                    }

                    this.mao.remove(i);
                    --i;
                }
            }
        }

        if (!cartasPossiveis.isEmpty()) { //Se tiver carta para jogar, jogue
            int maiorIndice, maior, indiceCartaJogada = 0;
            maiorIndice = maior = 0;
            for (int i = 1; i <= 4; i++) { //Acha a cor com mais cartas correspondentes
                if (quantidadeCores[i] > maior) {
                    maiorIndice = i;
                    maior = quantidadeCores[i];
                }
            }
            for (int i = 0; i < cartasPossiveis.size(); i++) { //Procura no vetor cartasDisponiveis a primeira aparição da cor para jogar
                if (cartasPossiveis.get(i).getCor().equals(cores[maiorIndice])) {
                    cartaJogada = cartasPossiveis.get(i);
                    cartasPossiveis.remove(i);
                    break;
                }
            }
            for (int i = 0; i < cartasPossiveis.size(); i++) {  //Repreenchendo a mão do jogador com as cartas que
                this.mao.add(cartasPossiveis.get(i));           //foram previamente tiradas
            }
            this.mesa.colocaNoTopoMonte(cartaJogada);

        } else {    //Senão, compre uma carta.
            int coringaMais4, coringa;
            coringa = coringaMais4 = -1;
            for (int i = 0; i < this.mao.size(); i++) { //Procura por CartasEspeciais
                cartaAtual = this.mao.get(i);
                if (cartaAtual instanceof CartaEspecial) {    //Se for carta especial
                    if (((CartaEspecial) cartaAtual).getEspecial().equals("+4")) {
                        coringaMais4 = i;
                    } else {
                        coringa = i;
                    }
                }
            }

            if (coringa != -1) {  //Se existir um coringa;
                for (int i = 0; i < this.mao.size(); i++) { //Preenche o vetor de cores para escolher a cor que tem mais cartas
                    cartaAtual = this.mao.get(i);

                    switch (cartaAtual.getCor()) {       //Incrementa o vetor de quantidade de cartas
                        case "Vermelho":
                            quantidadeCores[1]++;
                            break;
                        case "Azul":
                            quantidadeCores[2]++;
                            break;
                        case "Amarelo":
                            quantidadeCores[3]++;
                            break;
                        case "Verde":
                            quantidadeCores[4]++;
                            break;
                        default:
                            break;
                    }
                }
                int maiorIndice, maior;
                maiorIndice = maior = 0;
                for (int i = 1; i <= 4; i++) { //Acha a cor com mais cartas correspondentes
                    if (quantidadeCores[i] > maior) {
                        maiorIndice = i;
                        maior = quantidadeCores[i];
                    }
                }

                this.mao.get(coringa).setCor(cores[maiorIndice]);   //Escolho a cor do coringa
                this.mesa.colocaNoTopoMonte(this.mao.get(coringa)); //Jogo o coringa
                this.mao.remove(coringa);   //Removo o coringa da mão
                return;
            } else if (coringaMais4 != -1) { //Se não existir um coringa mas existir um +4, devo jogá-la
                for (int i = 0; i < this.mao.size(); i++) { //Preenche o vetor de cores para escolher a cor que tem mais cartas
                    cartaAtual = this.mao.get(i);

                    switch (cartaAtual.getCor()) {       //Incrementa o vetor de quantidade de cartas
                        case "Vermelho":
                            quantidadeCores[1]++;
                            break;
                        case "Azul":
                            quantidadeCores[2]++;
                            break;
                        case "Amarelo":
                            quantidadeCores[3]++;
                            break;
                        case "Verde":
                            quantidadeCores[4]++;
                            break;
                        default:
                            break;
                    }
                }
                int maiorIndice, maior;
                maiorIndice = maior = 0;
                for (int i = 1; i <= 4; i++) { //Acha a cor com mais cartas correspondentes
                    if (quantidadeCores[i] > maior) {
                        maiorIndice = i;
                        maior = quantidadeCores[i];
                    }
                }

                this.mao.get(coringaMais4).setCor(cores[maiorIndice]);   //Escolho a cor do +4
                this.mesa.colocaNoTopoMonte(this.mao.get(coringaMais4)); //Jogo o +4
                this.mao.remove(coringaMais4);   //Removo o +4 da mão
                return;
            } else {
                this.comprarCarta();
            }
        }
    }

}
