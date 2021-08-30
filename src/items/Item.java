package items;

import duelmons.Duelmon;

public abstract class Item {
	
	protected String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	protected abstract Duelmon use(Duelmon duelmon) throws Exception;
	

}
