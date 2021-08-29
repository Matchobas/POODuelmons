package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String nome;
	private List<Duelmon> duelmons = new ArrayList<Duelmon>();
	private int money = 0;
	
	public Player(String nome) {
		super();
		this.nome = nome;
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
}
