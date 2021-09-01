package game;

import java.io.IOException;
import java.util.Scanner;

import characters.Opponent;
import characters.Player;
import duelmons.Duelmon;
import duelmons.Fogarel;
import duelmons.Xarcado;
import items.Item;
import items.Potion;
import items.Revive;
import terrain.Grass;
import terrain.Sand;

public class Gameplay {
	public static void startGameplay(Scanner input, Player player) throws IOException {
		boolean out = false;
		
		System.out.println("------------------------------");
		System.out.println("Vamos comecar sua jornada " + player.getNome());
		System.out.println("------------------------------");
		System.out.println("Primeiro voce deve decidir qual seu primeiro Duelmon");
		System.out.println("Opcaoo\t Descricao");
		System.out.println("1\t Fogarel - Fogo");
		System.out.println("2\t Xarcado - Agua");
		System.out.println("9\t Sair do jogo");
		System.out.println("-------------------");
		System.out.println("Escolha uma opcao:");
		
		int option = input.nextInt();
		input.nextLine();
	
		switch (option) {
		case 1:
			Duelmon fogarel = new Fogarel();
			fogarel.setIsWild(false);
			fogarel.setLevel(5);
			fogarel.setMestre (player);
			player.addDuelmon(fogarel);
			
			addInitialItems(player);
			
			break;
		case 2:
			Duelmon xarcado = new Xarcado();
			xarcado.setIsWild(false);
			xarcado.setLevel(5);
			xarcado.setMestre (player);
			player.addDuelmon(xarcado);
			
			addInitialItems(player);
			
			break;
		case 9:
			boolean exited = GameOptions.sairJogo(input);
			if (exited) out = true;
			break;
		default:
			break;
		}
		
		if (!out) {
			System.out.println("------------------------------");
			System.out.println("Agora com seu " + player.getDuelmons().get(0).getName() + ", Eh hora"
					+ " de escolher para onde voce vai se aventurar!");
			System.out.println("------------------------------");
			System.out.println("Existem dois caminhos");
			System.out.println("Opcao\t Descricao");
			System.out.println("1\t Caminho para a cidade");
			System.out.println("2\t Caminho para a floresta");
			System.out.println("9\t Sair do jogo");
			System.out.println("-------------------");
			System.out.println("Escolha uma opcao:");
			
			option = input.nextInt();
			input.nextLine();
		
			switch (option) {
			case 1:
				System.out.println("A cidade parece abandonada, e tudo esta cheio de areia...");
				System.out.println("Ate que voce encontrou um oponente com um Fogarel!");
				
				Opponent opCidade = new Opponent("Oponente da cidade");
				opCidade.calculaRecompensa(1);
				Duelmon opFogarel = new Fogarel();
				opCidade.addDuelmon(opFogarel);
				Sand areia = new Sand();
				
				System.out.println("Pressione enter para iniciar a batalha!");
				System.in.read();
				player.desafiar(opCidade, areia);
				System.out.println("Pressione qualquer tecla para continuar");
				System.in.read();
				Main.gameState = "FIM";
				
				break;
			case 2:
				System.out.println("A grama alta tem um cheiro bom enquanto voce anda na floresta...");
				System.out.println("De repente voce enconta um oponente com um Xarcado!\n");
				
				Opponent opFloresta = new Opponent("Oponente da floresta");
				opFloresta.calculaRecompensa(1);
				Duelmon opXarcado = new Xarcado();
				opFloresta.addDuelmon(opXarcado);
				Grass grama = new Grass();
				
				System.out.println("Iniciando a batalha! *sons de comeco de batalha*\n");
				System.out.println("Pressione enter para iniciar a batalha!");
				System.in.read();
				player.desafiar(opFloresta, grama);
				System.out.println("Pressione enter para continuar");
				System.in.read();
				Main.gameState = "FIM";
				
				break;
			case 9:
				// Esse formato de sempre poder sair do jogo nao ta dando certo, melhor mudar pra outra coisa
				GameOptions.sairJogo(input);
				break;
			default:
				break;
			}
		}
	}
	
	public static void addInitialItems(Player player) {
		Item potion = new Potion();
		Item revive = new Revive();
		System.out.println("\nVoce tambem recebe uma " + potion.getNome() + " e um " + revive.getNome());
		
		player.addItem(potion);
		player.addItem(revive);
	}
}
