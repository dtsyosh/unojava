package modelo;

import java.io.IOException;

public class CartaEspecial extends Carta {

    String especial; //pode ser "+4" "Escolhe cor"

    public CartaEspecial(String cor, String especial, String caminho) throws IOException {
        super(caminho);
        this.especial = especial;
        super.setCor(cor);
    }

    public String getEspecial() {
        return especial;
    }

    public void setEspecial(String especial) {
        this.especial = especial;
    }

}
