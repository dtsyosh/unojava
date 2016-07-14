package modelo;

import java.io.IOException;

public class CartaNumero extends Carta {

    private int numero;

    public CartaNumero(String cor, int numero, String caminho) throws IOException {
        super(caminho);
        this.numero = numero;
        super.setCor(cor);
        //        File imagem = new File(nomeImagem);
        //        this.imagem = ImageIO.read(imagem);

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
