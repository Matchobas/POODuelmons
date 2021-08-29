package game;

public class Duelmon {
	private String name;
	private int level = 1;
	private String type;
	private Player mestre;
	private float vida;
	private boolean wild = true;
	private float attackStat;
	private float defenseStat;
	
	public Duelmon(String name, int level, String type, float attackStat, float defenseStat) {
		super();
		this.name = name;
		this.level = level;
		this.type = type;
		this.attackStat = attackStat;
		this.defenseStat = defenseStat;
	}
	
	public float attack() {
		// A intenção é checar modificador de tipo antes de retornar o valor de dano
		// também checar se foi um crítico
		return this.attackStat;
	}
	
	public float defend() {
		// Eu imaginei que a defesa fosse passiva, mas escolher se defender aumentaria ela de alguma forma
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
	}

	public boolean isWild() {
		return wild;
	}

	public void setWild(boolean wild) {
		this.wild = wild;
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
}
