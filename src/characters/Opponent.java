package characters;

public class Opponent extends Character {
	
	public Opponent(String nome) {
		super(nome);
	}
	
	public int calculaRecompensa(int level) {
		this.setMoney(50 * level);
		
		return this.getMoney();
	}
	
}
