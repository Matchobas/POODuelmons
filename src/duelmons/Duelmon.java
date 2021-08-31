package duelmons;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import characters.Player;
import items.Item;
import terrain.Terrain;

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
	
	protected float vidaMax;
	
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

	public float getVidaMax() {
		return vidaMax;
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
	
	public boolean batalhar (Duelmon duelmonOp, Terrain terreno) throws IOException {
		
		Scanner acao = new Scanner(System.in);
		
		String battleStatus = "continua";
		boolean continua = true;
		boolean isVencedor = true;
		
		System.out.println("Vida do " + this.getName() + ": " + this.getVida());
		System.out.println("Vida do " + duelmonOp.getName() + " oponente: " + duelmonOp.getVida());
		
		terreno.terrainDescription();
		
		while (continua) {
			terreno.terrainEffect(this, duelmonOp);
			System.out.println("------------------------------");
			System.out.println("Voce pode escolher entre as seguintes acoes:");
			System.out.println("------------------------------");
			System.out.println("Opcao\t Descricao");
			System.out.println("1\t Atacar o oponente");
			System.out.println("2\t Usar um item");
			System.out.println("Escolha sua acao:");
			
			String opcao = acao.nextLine();
			
			switch (opcao) {
				case "1":
					battleStatus = this.attackAction(duelmonOp);
					break;
				case "2":
					battleStatus = this.useItem(duelmonOp, acao);
					break;
				default:
					battleStatus = this.attackAction(duelmonOp);
					break;
			}
			
			if (battleStatus.equals("perdedor")) {
				isVencedor = false;
				continua = false;
			} else if (battleStatus.equals("vencedor")) {
				continua = false;
			}

		}
		
		terreno.terrainEffect(this, duelmonOp);
		return isVencedor;
	}
	
	private String attackAction(Duelmon duelmonOp) {
		float dano = 0;
		
		// Quem tem maior velocidade ataca primeiro
		if(this.getVelocidade() >= duelmonOp.getVelocidade()) {
			// Duelmon ataca		
			dano = this.getAttackStat() - duelmonOp.getDefenseStat();
			if (dano < 0)
				dano = 0;
			System.out.println( this.getName() + " ataca, causando " + dano + " de dano");
			duelmonOp.setVida(duelmonOp.getVida() - dano);
			System.out.println("Vida do " + this.getName() + ": " + this.getVida());
			System.out.println("Vida do " + duelmonOp.getName() + " oponente: " + duelmonOp.getVida());
			// Se a vida do duelmon oponente zerou, ele ganha
			if(duelmonOp.getVida() <= 0) {
				System.out.println(this.getName() + " derrotou o oponente!");
				return "vencedor";
			}
			// Duelmon oponente ataca em seguida
			dano = duelmonOp.getAttackStat() - this.getDefenseStat();
			System.out.println( duelmonOp.getName() + " oponente ataca, causando " + dano + " de dano");
			this.setVida(this.getVida() - dano);
			if (dano < 0)
				dano = 0;
			System.out.println("Vida do " + this.getName() + ": " + this.getVida());
			System.out.println("Vida do " + duelmonOp.getName() + " oponente: " + duelmonOp.getVida());
			//se a vida do duelmon zerou, ele perde
			if(this.getVida() <= 0) {
				System.out.println(this.getName() + " foi derrotado pelo oponente!");
				return "perdedor";
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
			System.out.println("Vida do " + duelmonOp.getName() + " oponente: " + duelmonOp.getVida());
			// Se a vida do duelmon zerou, ele perde
			if(this.getVida() <= 0) {
				System.out.println(this.getName() + " foi derrotado pelo oponente!");
				return "perdedor";
			}
			
			// Duelmon ataca em seguida		
			dano = this.getAttackStat() - duelmonOp.getDefenseStat();
			if (dano < 0)
				dano = 0;
			System.out.println( this.getName() + " ataca, causando " + dano + " de dano");
			duelmonOp.setVida(duelmonOp.getVida() - dano);
			System.out.println("Vida do " + this.getName() + ": " + this.getVida());
			System.out.println("Vida do " + duelmonOp.getName() + " oponente: " + duelmonOp.getVida());
			// Se a vida do duelmon oponente zerou, ele ganha
			if(duelmonOp.getVida() <= 0) {
				System.out.println(this.getName() + " derrotou o oponente!");
				return "vencedor";
			}
		}
		
		return "continua";
	}
	
	private String useItem(Duelmon duelmonOp, Scanner acao) {
		List<Item> availableItems = this.getMestre().getItems();
		float dano = 0;
		boolean used = false;
		
		while (!used) {
			System.out.println("------------------------------");
			System.out.println("Voce possui os seguintes items:");
			System.out.println("------------------------------");
			
			System.out.println("Opcao\t Descricao");
			for(int i = 0; i < availableItems.size(); i++) {
				System.out.println((i+1) + "\t " + availableItems.get(i).getNome());
			}
			
			System.out.println("Escolha sua acao:");
			
			int opcao = acao.nextInt() - 1;
			acao.nextLine();
			
			used = availableItems.get(opcao).use(this);
			
		}
		
		// Duelmon oponente ataca de qualquer forma
		dano = duelmonOp.getAttackStat() - this.getDefenseStat();
		if (dano < 0)
			dano = 0;
		System.out.println( duelmonOp.getName() + " oponente ataca, causando " + dano + " de dano");
		this.setVida(this.getVida() - dano);
		System.out.println("Vida do " + this.getName() + ": " + this.getVida());
		System.out.println("Vida do " + this.getName() + " oponente: " + duelmonOp.getVida());
		
		// Se a vida do duelmon zerou, ele perde
		if(this.getVida() <= 0) {
			System.out.println(this.getName() + " foi derrotado pelo oponente!");
			return "perdedor";
		}
		
		return "continua";
	}
}
