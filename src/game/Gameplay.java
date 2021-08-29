package game;

import java.util.Scanner;

public class Gameplay {
	public static void startGameplay(Scanner input, Player player) {
		System.out.println("------------------------------");
		System.out.println("Vamos começar sua jornada " + player.getNome());
		System.out.println("------------------------------");
		System.out.println("Opção\t Descrição");
		System.out.println("1\t Começar novo jogo");
		System.out.println("2\t Sair do jogo");
		System.out.println("-------------------");
		System.out.println("Escolha uma opção:");
		
		int opcao = input.nextInt();
		input.nextLine();
	
		switch (opcao) {
		case 1:
			
			break;
		case 2:
			
			break;
		default:
			break;
		}
	}
}
