/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author yosh
 */
public class TelaUnoNaMao extends JFrame {
    private JButton btnJogarCarta, btnUno;
    private JLabel imgBaralho, imgMonteDescarte, lblNomeJogador, lblComputador;
    private JList listCartasJogador, listCartasComputador;
    private JScrollPane spCartasJogador, spCartasComputador;
    
    public TelaUnoNaMao(){
        //Definir Titulo
        setTitle("Uno");
        //Inicializar os componentes
        btnJogarCarta = new JButton("Jogar Carta");
        btnUno = new JButton("Uno");
        imgBaralho = new JLabel("");
        imgMonteDescarte = new JLabel("");
        lblNomeJogador = new JLabel("Nome Jogador");
        lblComputador = new JLabel("Computador");
        listCartasComputador = new JList();
        listCartasJogador = new JList();
        spCartasComputador = new JScrollPane();
        spCartasJogador = new JScrollPane();
        //Alterar componentes
        listCartasComputador.setEnabled(false);
        //Criar o painel principal
        JPanel painel = new JPanel();
        //Colocar um layout pro painel
        painel.setLayout(new GridBagLayout());
        //Adicionar os componentes ao painel
        
        painel.add(lblComputador);
        painel.add(lblNomeJogador);
        painel.add(listCartasComputador);
        painel.add(listCartasJogador);
        
        
        
        setContentPane(painel);
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
  
}
