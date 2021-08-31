package terrain;

import duelmons.Duelmon;

public abstract class Terrain {

	protected String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract void terrainEffect(Duelmon duelmon1, Duelmon duelmon2);

	public abstract void terrainDescription();
}

