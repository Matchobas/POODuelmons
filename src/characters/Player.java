package characters;

import java.io.IOException;

import duelmons.Duelmon;
import terrain.Terrain;

public class Player extends Character {

	public Player(String nome) {
		super(nome);
	}
	
	public void capturarDuelmon(Duelmon duelmon) {
		this.addDuelmon(duelmon);
	}

	public void desafiar(Character oponente, Terrain terreno) throws IOException {
		
		boolean vitoria = this.getDuelmons().get(0)
				.batalhar(oponente.getDuelmons().get(0), terreno); 
		
		if(vitoria) {
			// O jogador ganhou, ele recebe o dinheiro do oponente
			this.setMoney(this.getMoney() + oponente.getMoney());
		}
		else {
			System.out.println("Infelizmente você perdeu, mas que tal tentar novamente?");
		}
	}
}
