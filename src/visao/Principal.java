/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.*;

/**
 *
 * @author yosh
 */
public class Principal {

    public static void main(String[] args) throws IOException {
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        TelaUno tela = new TelaUno();
        tela.setVisible(true);
        /*
        ArrayList<Carta> teste = new ArrayList();

        Carta carta = new CartaNumero("Azul", 1, "b1.jpg");
        Carta carta2 = new CartaNumero("Vermelho", 2, "r2.jpg");
        Carta carta3 = new CartaNumero("Azul", 3, "b3.jpg");

        teste.add(carta);
        teste.add(carta2);
        teste.add(carta2);
        teste.add(carta3);

        for (Carta x : teste) {
            System.out.println(x.getCor());
        }
        System.out.println("");
        for (int i = 0; i < teste.size(); i++) {
            if (teste.get(i).getCor().equals("Vermelho")) {
                teste.remove(i);
                --i;
            }
        }
        for (Carta x : teste) {
            System.out.println(x.getCor());
        }
        */
    }

}
