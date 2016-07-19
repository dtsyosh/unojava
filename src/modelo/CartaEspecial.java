package modelo;

import java.io.IOException;

public class CartaEspecial extends Carta {

    private String especial; //pode ser "+4" "Escolhe cor"
    private boolean efeito;

    public CartaEspecial(String cor, String especial, String caminho) throws IOException {
        super(caminho);
        this.especial = especial;
        super.setCor(cor);
        this.efeito = true;
    }

    public String getEspecial() {
        return especial;
    }

    public void setEspecial(String especial) {
        this.especial = especial;
    }

}
