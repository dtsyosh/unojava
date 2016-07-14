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
        int i = 0;
        int [] quantidadeCores = {0,0,0,0,0}; //1 Vermelho, 2 Azul, 3 Amarelo, 4 Verde
        
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
        }
        //A partir desse ponto eu ja tenho o vetor cartasPossiveis pronto.
        
        return carta;
    }

}
