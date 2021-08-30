package game;

import java.io.IOException;
import java.util.Scanner;

import characters.Player;

public class Main {

	public static boolean gameLoop = true;
	public static Player player;
	
	public static String gameState = "START_MENU";
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		while (gameLoop) {
			
			switch (gameState) {
			case "START_MENU":
				StartMenu.startGame(input);
				break;
			
			case "GAMEPLAY":
				Gameplay.startGameplay(input, player);
				break;
			}
		}
	}

}
