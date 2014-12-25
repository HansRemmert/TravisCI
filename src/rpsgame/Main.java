package rpsgame;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("This project is now in GitHub");
		System.out.println("This line is useless");
		System.out.println("This line is useless to share.");

		RPSModel model = new RPSModel();
		System.out.println("Wer zuerst " + model.POINTS_TO_WIN
				+ " Punkte erreicht gewinnt!");

		do {
			// User input
			Scanner userInput = new Scanner(System.in);
			String userChoise = userInput.nextLine().toLowerCase();

			if (model.validateUserInput(userChoise)) {
				// PC input
				String pcChoise = model.getPcChoise();
				System.out.println("PC waehlst: " + pcChoise);

				// Result
				model.calcTheWinner(userChoise, pcChoise);

				// Scoring
				System.out.println(model.getUserPoints() + " (DU) zu "
						+ model.getPcPoints() + " (PC)");
				model.calcGameResult();
			}
		} while (model.gameIsRunning);
	}
}