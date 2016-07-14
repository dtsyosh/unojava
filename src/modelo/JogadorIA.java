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

        for (Carta x : this.getMao()) {    //Percorre a mão procurando cartas que podem ser jogadas           
            if (x.getCor().equals(carta.getCor()) || ((CartaNumero) x).getNumero() == ((CartaNumero) carta).getNumero()) {
                cartasPossiveis.add(this.getMao().remove(i));
            }
            if (x.getCor().equals("Preto")) {
                cartasPossiveis.add(this.getMao().remove(i));
            }
            i++;
        }

        return carta;
    }

}
