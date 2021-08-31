package terrain;

import duelmons.Duelmon;

public class Grass extends Terrain{

	public Grass () {
		this.nome = "Grama";
	}
	
	@Override
	public void terrainEffect(Duelmon duelmon1, Duelmon duelmon2){
		if (duelmon1.getVida() > 0) {
			duelmon1.setVida(duelmon1.getVida() + 3);
		}
		
		if (duelmon2.getVida() > 0) {
			duelmon2.setVida(duelmon2.getVida() + 3);
		}
	}

	@Override
	public void terrainDescription() {
		System.out.println("A " + this.getNome() + " em sua volta parece fazer os Duelmons mais saudaveis!");
	}
}