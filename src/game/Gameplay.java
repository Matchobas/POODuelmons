package game;

import java.util.Scanner;

public class Gameplay {
	public static void startGameplay(Scanner input, Player player) {
		boolean out = false;
		
		System.out.println("------------------------------");
		System.out.println("Vamos começar sua jornada " + player.getNome());
		System.out.println("------------------------------");
		System.out.println("Primeiro você deve decidir qual seu primeiro Duelmon");
		System.out.println("Opção\t Descrição");
		System.out.println("1\t Fogarel - Fogo");
		System.out.println("2\t Xarcado - Água");
		System.out.println("9\t Sair do jogo");
		System.out.println("-------------------");
		System.out.println("Escolha uma opção:");
		
		int option = input.nextInt();
		input.nextLine();
	
		switch (option) {
		case 1:
			Duelmon fogarel = new Duelmon("Fogarel", 5, "Fogo", 10, 5);
			player.addDuelmon(fogarel);
			break;
		case 2:
			Duelmon xarcado = new Duelmon("Xarcado", 5, "Água", 6, 9);
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
			System.out.println("Agora com seu " + player.getDuelmons().get(0).getName() + ", é hora"
					+ "\n de escolher para onde você vai");
			System.out.println("------------------------------");
			System.out.println("Existem dois caminhos");
			System.out.println("Opção\t Descrição");
			System.out.println("1\t Caminho para a cidade");
			System.out.println("2\t Caminho para a floresta");
			System.out.println("9\t Sair do jogo");
			System.out.println("-------------------");
			System.out.println("Escolha uma opção:");
			
			option = input.nextInt();
			input.nextLine();
		
			switch (option) {
			case 1:
				// Aqui seria para serem criadas as duas áreas do jogo
				break;
			case 2:
				
				break;
			case 9:
				// Esse formato de sempre poder sair do jogo não ta dando certo, melhor mudar pra outra coisa
				GameOptions.sairJogo(input);
				break;
			default:
				break;
			}
		}
	}
}
