package items;

import duelmons.Duelmon;

public class Potion extends Item {
	
	public Potion () {
		this.nome = "Pocao";
	}

	@Override
	protected Duelmon use(Duelmon duelmon) throws Exception {
		
		if (duelmon.getVida() < 0.01) {
			throw new Exception("Nao eh possivel usar pocao em um duelmon desmaiado");
		}
		else {
			duelmon.setVida(duelmon.getVida() + 20);
			return duelmon;
		}
	}
}
