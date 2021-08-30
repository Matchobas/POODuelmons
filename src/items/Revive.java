package items;

import duelmons.Duelmon;

public class Revive extends Item {
	
	public Revive() {
		this.nome = "Ressucitador";
	}

	@Override
	protected Duelmon use(Duelmon duelmon) throws Exception {
		if (duelmon.getVida() > 0) {
			throw new Exception("Nao eh possivel usar ressucitador em um duelmon vivo");
		}
		else {
			duelmon.setVida(10);
			return duelmon;
		}
	}

}
