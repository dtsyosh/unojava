/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author yosh
 */
public class JogadorIA extends Jogador {

    public JogadorIA(String nome) {
        super(nome);
    }

    public Carta realizarJogada(Carta carta) {     // <-- mesa.verTopoMonte()
        ArrayList<Carta> cartasPossiveis = new ArrayList();
        Carta cartaJogada = null;
        int i = 0;
        Integer[] quantidadeCores = {0, 0, 0, 0, 0}; //1 Vermelho, 2 Azul, 3 Amarelo, 4 Verde
        String [] cores = {"", "Vermelho", "Azul", "Amarelo", "Verde"};
        while(cartasPossiveis.isEmpty()){   //Enquanto não tiver cartas para jogar
        for (Carta x : this.getMao()) {    //Percorre a mão procurando cartas que podem ser jogadas           
            if (x.getCor().equals(carta.getCor()) || ((CartaNumero) x).getNumero() == ((CartaNumero) carta).getNumero()) {
                cartasPossiveis.add(this.getMao().remove(i));
                
                switch(x.getCor()){
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
            i++;
            //Achar uma forma de comprar carta
        }
        }
        //A partir desse ponto eu ja tenho o vetor cartasPossiveis pronto.
        int maiorIndice, maior;
        maiorIndice = maior = 0;
        
        for(i = 1; i <= 4; i++){ //Acha a maior cor com mais cartas correspondentes
            if(quantidadeCores[i] > maior){
                maiorIndice = i;
                maior = quantidadeCores[i];
            }
        }
        for(Carta x : cartasPossiveis){ //Procura no vetor cartasDisponiveis a primeira aparição da cor para jogar
            if(x.getCor().equals(cores[maiorIndice]))
                cartaJogada = x;
        }
        
        return cartaJogada;
    }

}
