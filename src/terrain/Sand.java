package terrain;

import duelmons.Duelmon;

public class Sand extends Terrain{
	
	public int timesApplied = 0; 
	
	public Sand() {
		this.nome = "Areia";
	}

	@Override
	public void terrainEffect(Duelmon duelmon1, Duelmon duelmon2){
		duelmon1.setAttackStat(duelmon1.getAttackStat() + 3);
		duelmon2.setAttackStat(duelmon2.getAttackStat() + 3);
		timesApplied += 1;
		
		if (duelmon1.getVida() <= 0 || duelmon2.getVida() <= 0) {
			duelmon1.setAttackStat(duelmon1.getAttackStat() - (3 * timesApplied));
			duelmon2.setAttackStat(duelmon2.getAttackStat() - (3 * timesApplied));
			timesApplied = 0;
		}
	}
	
	@Override
	public void terrainDescription() {
		System.out.println("A " + this.getNome() + " em sua volta parece fazer os Duelmons mais ferozes!");
	}

}
