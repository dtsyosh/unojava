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

    public Carta realizarJogada(Carta cartaTopoMonte) {     // <-- mesa.verTopoMonte()
        ArrayList<Carta> cartasPossiveis = new ArrayList(); //Vetor que guarda todas as cartas possiveis de serem jogadas
        Carta cartaJogada = null;
        Carta cartaAtual;

        Integer[] quantidadeCores = {0, 0, 0, 0, 0}; //1 Vermelho, 2 Azul, 3 Amarelo, 4 Verde
        String[] cores = {"", "Vermelho", "Azul", "Amarelo", "Verde"};

        //Arrumar ConcurrentModificationException
        do {   //Enquanto não tiver cartas para jogar não sai do loop
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

            if (cartasPossiveis.isEmpty()) {
                this.comprarCarta();
            } else {
                break;
            }
        } while (true);
        //A partir desse ponto eu ja tenho o vetor cartasPossiveis pronto.
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

        for (int i = 0; i < cartasPossiveis.size(); i++) {
            this.mao.add(cartasPossiveis.get(i));
        }

        return cartaJogada;
    }

}
