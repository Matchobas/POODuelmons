package items;

import duelmons.Duelmon;

public class Revive extends Item {
	
	public Revive() {
		this.nome = "Ressucitador";
	}

	@Override
	public boolean use(Duelmon duelmon) {
		if (duelmon.getVida() > 0) {
			System.out.println("Nao eh possivel usar ressucitador em um duelmon vivo");
			return false;
		}
		else {
			duelmon.setVida(30);
			return true;
		}
	}

	@Override
	public void itemDescription() {
		System.out.println("Revive um Duelmon derrotado -- Recupera a vida do Duelmon para 30");
	}

}
