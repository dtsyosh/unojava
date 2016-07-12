package modelo;

import java.io.IOException;

public class CartaSimbolo extends Carta {

    private String simbolo; //deve ser "bloqueio", "inverte" ou "+2"

    public CartaSimbolo(String cor, String simbolo, String caminho) throws IOException {
        super(caminho);
        this.simbolo = simbolo;
        this.cor = cor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

}
