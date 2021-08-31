package characters;

public class Opponent extends Character {
	
	public Opponent(String nome, int level) {
		super(nome);
		this.setMoney(50 * level);
	}
	
}
