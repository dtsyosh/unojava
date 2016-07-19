package modelo;

import java.io.IOException;

public class CartaSimbolo extends Carta {

    private String simbolo; //deve ser "bloqueio", "inverte" ou "+2"
    private String corEscolhida;
    private boolean efeito;

    public CartaSimbolo(String cor, String simbolo, String caminho) throws IOException {
        super(caminho);
        this.simbolo = simbolo;
        super.setCor(cor);
        this.efeito = true;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public String getCorEscolhida(){
        return this.corEscolhida;
    }
    
    public void setCorEscolhida(String cor){
        this.corEscolhida = cor;
    }
    

}
