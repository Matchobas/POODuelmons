package game;

import java.io.IOException;
import java.util.Scanner;

import characters.Opponent;
import characters.Player;
import duelmons.Duelmon;
import duelmons.Fogarel;
import duelmons.Xarcado;

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
			break;
		case 2:
			Duelmon xarcado = new Xarcado();
			xarcado.setIsWild(false);
			xarcado.setLevel(5);
			xarcado.setMestre (player);
			player.addDuelmon(xarcado);
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
					+ "\n de escolher para onde voce vai");
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
				System.out.println("Na cidade voce encontrou um oponente com um Fogareu!");
				Opponent opCidade = new Opponent("Oponente da cidade");
				Duelmon opFogarel = new Fogarel();
				opCidade.addDuelmon(opFogarel);
				System.out.println("Pressione enter para iniciar a batalha!");
				System.in.read();
				player.desafiar(opCidade);
				System.out.println("Pressione qualquer tecla para continuar");
				System.in.read();
				
				break;
			case 2:
				System.out.println("Na floresta voce encontrou um oponente com um Xarcado!");
				Opponent opFloresta = new Opponent("Oponente da cidade");
				Duelmon opXarcado = new Xarcado();
				opFloresta.addDuelmon(opXarcado);
				System.out.println("Iniciando a batalha!");
				player.desafiar(opFloresta);
				System.out.println("Pressione enter para continuar");
				System.in.read();
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
}
