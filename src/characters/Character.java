package characters;

import java.util.ArrayList;
import java.util.List;

import duelmons.Duelmon;

public abstract class Character {
	
	private String nome;
	private List<Duelmon> duelmons;
	protected int money;
	
	public Character(String nome) {
		this.nome = nome;
		this.money = 0;
		this.duelmons =  new ArrayList<Duelmon>();		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Duelmon> getDuelmons() {
		return duelmons;
	}

	public void addDuelmon(Duelmon duelmon) {
		this.duelmons.add(duelmon);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public abstract void desafiar (Character character);

}
