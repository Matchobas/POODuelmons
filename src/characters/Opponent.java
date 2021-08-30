package characters;

public class Opponent extends Character {
	
	public Opponent(String nome) {
		super(nome);
		this.setMoney(50);
	}

	@Override
	public void desafiar(Character player) {
		
		if(this.getDuelmons().get(0).batalhar(player.getDuelmons().get(0)));
			// TO DO:oponente venceu a batalha... fazer o que?
		else
			// Se o oponente perdeu ele da dinheiro para o player
			player.setMoney(player.getMoney() + this.getMoney());
			
	}
	
}
