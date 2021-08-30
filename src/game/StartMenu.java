package game;

import java.util.Scanner;

import characters.Player;

public class StartMenu {
	public static void startGame(Scanner input) {
		System.out.println("------------------------------");
		System.out.println("Bem vindo ao mundo de Duelmons");
		System.out.println("------------------------------");
		System.out.println("Opcao\t Descricao");
		System.out.println("1\t Comecar novo jogo");
		System.out.println("2\t Sair do jogo");
		System.out.println("-------------------");
		System.out.println("Escolha uma opcao:");
		
		int opcao = input.nextInt();
		input.nextLine();

		switch (opcao) {
		case 1:
			Main.gameState = "GAMEPLAY";
			Main.player = comecarJogo(input);
			break;
		case 2:
			GameOptions.sairJogo(input);
			break;
		default:
			break;
		}
	}
	
	public static Player comecarJogo(Scanner input) {
		System.out.println("------------------------------");
		System.out.println("Hora de escolher o nome do seu personagem");
		System.out.println("------------------------------");
		System.out.println("Digite seu nome:");
		
		String playerName = input.nextLine();
		Player player = new Player(playerName);
		
		return player;
	}
}
