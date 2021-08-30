package characters;

import duelmons.Duelmon;

public class Player extends Character {

	public Player(String nome) {
		super(nome);
	}
	
	public void capturarDuelmon(Duelmon duelmon) {
		this.addDuelmon(duelmon);
	}

	@Override
	public void desafiar(Character oponente) {
		
		if(this.getDuelmons().get(0).batalhar(oponente.getDuelmons().get(0))) {
			//o jogador ganhou, ele recebe o dinheiro do oponente
			this.setMoney(this.getMoney() + oponente.getMoney());
		}
		else {
			//TODO: o que acontence se ele perder?
		}
	}
}
