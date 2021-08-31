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
	
	public abstract void itemDescription();
	
	public abstract boolean use(Duelmon duelmon);
	

}
