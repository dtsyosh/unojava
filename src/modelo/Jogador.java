package modelo;

import java.util.ArrayList;

public class Jogador {
	String nome;
	ArrayList<Carta> mao;
	
	public Jogador(String nome){
		this.nome = nome;
		this.mao = new ArrayList<Carta>();
	}
	
	public void compraCarta(Carta carta){
		this.mao.add(carta);
	}
	
	public Carta jogarCarta(int indice){
		return this.mao.remove(indice - 1);
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public ArrayList<Carta> getMao(){
		return this.mao;
	}
        

}
