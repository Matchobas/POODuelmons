package characters;

import java.util.ArrayList;
import java.util.List;

import duelmons.Duelmon;
import items.Item;

public class Character {
	
	private String nome;
	private List<Duelmon> duelmons;
	private List<Item> items;
	protected int money;
	
	public Character(String nome) {
		this.nome = nome;
		this.money = 0;
		this.duelmons =  new ArrayList<Duelmon>();
		this.items = new ArrayList<Item>();
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

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
