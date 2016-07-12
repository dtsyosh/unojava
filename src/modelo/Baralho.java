package modelo;

import java.io.IOException;
import java.util.Stack;
import java.util.Collections;

public class Baralho {

    private Stack<Carta> cartas;

    public Baralho() throws IOException {
        this.cartas = new Stack(); //Pilha de cartas
        this.cartas = criarCartas();
        Collections.shuffle(this.cartas);
    }

    //Adiciona cartas no baralho
    public void adicionarCartas(Carta carta) {
        this.cartas.push(carta);
    }
    //método responsável pela compra de cartas

    public Carta darCarta() {
        return this.cartas.pop();
    }

    public Stack<Carta> getCartas() {
        return this.cartas;
    }

    public void embaralhar() {
        Collections.shuffle(this.cartas);
    }

    private Stack<Carta> criarCartas() throws IOException { //função que cria automático todas as cartas
        CartaNumero novaCartaNumero;
        CartaSimbolo novaCartaSimbolo;
        CartaEspecial novaCartaEspecial;

        Stack<Carta> baralho = new Stack<>();
        String[] cor = {"Verde", "Vermelho", "Amarelo", "Azul"};
        String[] corCarta = {"g", "r", "y", "b"};

        String caminho;

        int indice, j;
        j = indice = 0;
        while (true) {
            if (j == 10) {
                j = 0;
                indice++;
            }
            if (indice == 4) {
                break;		//se o indice chegar a 4 quer dizer que ja adicionou todas as cores de carta (0 ~ 3)
            }
            novaCartaNumero = new CartaNumero(cor[indice], j, corCarta[indice] + "" + j + ".jpg");
            baralho.push(novaCartaNumero);
            if (j != 0) {
                baralho.push(novaCartaNumero);	//0 s� possui 1 unidade
            }
            j++;
        }

        novaCartaEspecial = new CartaEspecial("Preto", "+4", "+4.jpg");
        for (int i = 0; i < 4; i++) {
            baralho.push(novaCartaEspecial);
        }
        novaCartaEspecial = new CartaEspecial("Preto", "Troca Cor", "Color.jpg");
        for (int i = 0; i < 4; i++) {
            baralho.push(novaCartaEspecial);
        }

        for (int i = 0; i < 2; i++) {
            novaCartaSimbolo = new CartaSimbolo("Azul", "+2", "b+2.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Vermelho", "+2", "r+2.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Amarelo", "+2", "y+2.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Verde", "+2", "g+2.jpg");
            baralho.push(novaCartaSimbolo);

            novaCartaSimbolo = new CartaSimbolo("Azul", "Bloqueia", "bblok.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Vermelho", "Bloqueia", "rblok.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Amarelo", "Bloqueia", "yblok.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Verde", "Bloqueia", "gblok.jpg");
            baralho.push(novaCartaSimbolo);

            novaCartaSimbolo = new CartaSimbolo("Azul", "Volta", "brev.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Vermelho", "Volta", "rrev.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Amarelo", "Volta", "yrev.jpg");
            baralho.push(novaCartaSimbolo);
            novaCartaSimbolo = new CartaSimbolo("Verde", "Volta", "grev.jpg");
            baralho.push(novaCartaSimbolo);

        }
        return baralho;
    }

}
