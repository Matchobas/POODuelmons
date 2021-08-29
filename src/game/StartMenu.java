package game;

import java.util.Scanner;

public class StartMenu {
	public static void startGame(Scanner input) {
		System.out.println("------------------------------");
		System.out.println("Bem vindo ao mundo de Duelmons");
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
			Main.player = comecarJogo(input);
			Main.gameState = "GAMEPLAY";
			break;
		case 2:
			sairJogo(input);
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
	
	public static void sairJogo(Scanner input) {
		System.out.println("------------------------------");
		System.out.println("Você tem certeza que deseja sair do jogo?");
		System.out.println("------------------------------");
		System.out.println("Opção\t Descrição");
		System.out.println("1\t Sim");
		System.out.println("2\t Não");
		System.out.println("-------------------");
		System.out.println("Escolha uma opção:");
		
		int opcao = input.nextInt();
		input.nextLine();

		switch (opcao) {
		case 1:
			Main.gameLoop = false;
			break;
		case 2:
			break;
		default:
			break;
		}
	}
}
