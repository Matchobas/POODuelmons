package game;

public class Player {
	private String nome;
	private int duelmons;
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

	public int getDuelmons() {
		return duelmons;
	}

	public void setDuelmons(int duelmons) {
		this.duelmons = duelmons;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
