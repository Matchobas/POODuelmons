package duelmons;

public class Xarcado extends Duelmon {
	
	public Xarcado() {
		super();
		this.setName("Xarcado");
		this.setLevel(1);
		this.setType("Agua");
		this.setVida(80);
		this.setAttackStat(30);
		this.setDefenseStat(15);
		this.setVelocidade(13);
		vidaMax = this.getVida();
	}

}
