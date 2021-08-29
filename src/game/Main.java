package game;

import java.util.Scanner;

public class Main {

	public static boolean gameLoop = true;
	public static Player player;
	
	public static String gameState = "START_MENU";
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while (gameLoop) {
			
			switch (gameState) {
			case "START_MENU":
				StartMenu.comecarJogo(input);
				break;
			
			case "GAMEPLAY":
				Gameplay.startGameplay(input, player);
				break;
			}
		}
	}

}
