package items;

import duelmons.Duelmon;

public class Potion extends Item {
	
	public Potion () {
		this.nome = "Pocao";
	}

	@Override
	public boolean use(Duelmon duelmon){
		
		if (duelmon.getVida() < 0.01) {
			System.out.println("Nao eh possivel usar pocao em um duelmon desmaiado");
			return false;
		}
		else {
			duelmon.setVida(duelmon.getVida() + 50);
			if (duelmon.getVida() > duelmon.getVidaMax()) {
				duelmon.setVida(duelmon.getVidaMax());
			}
			return true;
		}
	}

	@Override
	public void itemDescription() {
		System.out.println("Pocao de recuperacao de vida -- Recupera 60 pontos de vida");
	}
}
