package modelo;

import java.io.IOException;

public class CartaEspecial extends Carta {

    private String especial; //pode ser "+4" "Troca cor"
    private int efeito;

    public CartaEspecial(String cor, String especial, String caminho) throws IOException {
        super(caminho);
        this.especial = especial;
        super.setCor(cor);
        this.efeito = 1;
    }

    public String getEspecial() {
        return especial;
    }

    public void setEspecial(String especial) {
        this.especial = especial;
    }

    public int getEfeito() {
        return efeito;
    }

    public void desativarEfeito() {
        this.efeito = 0;
    }

    public void ativarEfeito() {
        this.efeito = 1;
    }

}
