package duelmons;

import characters.Player;

public class Duelmon {
	private String name;
	private int level;
	private String type;
	private float velocidade;
	private Player mestre;
	private float vida;
	private boolean isWild;
	private float attackStat;
	private float defenseStat;
	
	public Duelmon() {
		this.isWild = true;
	}
	
	public float attack() {
		return this.attackStat;
	}
	
	public float defend() {
		return this.defenseStat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Player getMestre() {
		return mestre;
	}

	public void setMestre(Player mestre) {
		this.mestre = mestre;
	}

	public float getVida() {
		return vida;
	}

	public void setVida(float vida) {
		this.vida = vida;
		if (this.vida < 0)
			this.vida = 0;
	}

	public boolean isWild() {
		return isWild;
	}

	public void setIsWild(boolean wild) {
		this.isWild = wild;
	}
	
	public float getAttackStat() {
		return attackStat;
	}

	public void setAttackStat(float attackStat) {
		this.attackStat = attackStat;
	}

	public float getDefenseStat() {
		return defenseStat;
	}

	public void setDefenseStat(float defenseStat) {
		this.defenseStat = defenseStat;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}
	
	public boolean batalhar (Duelmon duelmonOp) {
		
		boolean continua = true;
		boolean isVencedor = true;
		float dano = 0;
		
		System.out.println("Vida do " + this.getName() + ": " + this.getVida());
		System.out.println("Vida do " + this.getName() + " oponente: " + duelmonOp.getVida());
		
		while (continua) {
			// Quem tem maior velocidade ataca primeiro
			if(this.getVelocidade() >= duelmonOp.getVelocidade()) {
				// Duelmon ataca		
				dano = this.getAttackStat() - duelmonOp.getDefenseStat();
				if (dano < 0)
					dano = 0;
				System.out.println( this.getName() + " ataca, causando " + dano + " de dano");
				duelmonOp.setVida(duelmonOp.getVida() - dano);
				System.out.println("Vida do " + this.getName() + ": " + this.getVida());
				System.out.println("Vida do " + this.getName() + " oponente: " + duelmonOp.getVida());
				// Se a vida do duelmon oponente zerou, ele ganha
				if(duelmonOp.getVida() <= 0) {
					System.out.println(this.getName() + " derrotou o oponente!");
					continua = false;
					return isVencedor;
				}
				// Duelmon oponente ataca em seguida
				dano = duelmonOp.getAttackStat() - this.getDefenseStat();
				System.out.println( duelmonOp.getName() + " oponente ataca, causando " + dano + " de dano");
				this.setVida(this.getVida() - dano);
				if (dano < 0)
					dano = 0;
				System.out.println("Vida do " + this.getName() + ": " + this.getVida());
				System.out.println("Vida do " + this.getName() + " oponente: " + duelmonOp.getVida());
				//se a vida do duelmon zerou, ele perde
				if(this.getVida() <= 0) {
					System.out.println(this.getName() + " foi derrotado pelo oponente!");
					isVencedor = false;
					return isVencedor;
				}
			}
			else {
				// Duelmon oponente ataca primeiro
				dano = duelmonOp.getAttackStat() - this.getDefenseStat();
				if (dano < 0)
					dano = 0;
				System.out.println( duelmonOp.getName() + " oponente ataca, causando " + dano + " de dano");
				this.setVida(this.getVida() - dano);
				System.out.println("Vida do " + this.getName() + ": " + this.getVida());
				System.out.println("Vida do " + this.getName() + " oponente: " + duelmonOp.getVida());
				//se a vida do duelmon zerou, ele perde
				if(this.getVida() <= 0) {
					System.out.println(this.getName() + " foi derrotado pelo oponente!");
					isVencedor = false;
					return isVencedor;
				}
				
				// Duelmon ataca em seguida		
				dano = this.getAttackStat() - duelmonOp.getDefenseStat();
				if (dano < 0)
					dano = 0;
				System.out.println( this.getName() + " ataca, causando " + dano + " de dano");
				duelmonOp.setVida(duelmonOp.getVida() - dano);
				System.out.println("Vida do " + this.getName() + ": " + this.getVida());
				System.out.println("Vida do " + this.getName() + " oponente: " + duelmonOp.getVida());
				// Se a vida do duelmon oponente zerou, ele ganha
				if(duelmonOp.getVida() <= 0) {
					System.out.println(this.getName() + " derrotou o oponente!");
					continua = false;
					return isVencedor;
				}

			}

		}
		
		return isVencedor;
	}
}
