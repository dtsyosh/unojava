package modelo;

import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;

public abstract class Carta {

    private String cor;
    private ImageIcon imagem;

    protected Carta(String arquivo) throws IOException {
        this.imagem = new ImageIcon(getClass().getResource("/imagens/" + arquivo));
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public ImageIcon getImagem() {
        return this.imagem;
    }

}
