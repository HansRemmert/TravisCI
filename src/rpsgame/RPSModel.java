package rpsgame;

public class RPSModel {

	public final int POINTS_TO_WIN = 3;

	int userPoints = 0;
	int pcPoints = 0;
	public boolean gameIsRunning = true;


	public boolean validateUserInput(String input) {
		if (input.equals("r") || input.equals("p") || input.equals("s")) {
			System.out.println("Du waehlst: " + input);
			return true;
		} else {
			System.out.println("Keine gueltige Eingabe!");
			return false;
		}
	}

	public String getPcChoise() {
		switch ((int) ((Math.random() * 3) + 1)) {
		case 1:
			return "r";
		case 2:
			return "p";
		}
		return "s";
	}

	public void calcTheWinner(String userChoice, String pcChoice) {

		if (userChoice.equals("r") && pcChoice.equals("r")
				|| userChoice.equals("p") && pcChoice.equals("p")
				|| userChoice.equals("s") && pcChoice.equals("s")) {
			System.out.println("Unentschieden!");
			return;
		}

		if (userChoice.equals("r") && pcChoice.equals("s")
				|| userChoice.equals("p") && pcChoice.equals("r")
				|| userChoice.equals("s") && pcChoice.equals("p")) {
			userPoints++;
			System.out.println("Ein Punkt fuer Dich!");
			return;
		} else {
			System.out.println("Ein Punkt fuer den PC!");
			pcPoints++;
		}
	}

	public int getUserPoints() {
		return userPoints;
	}

	public int getPcPoints() {
		return pcPoints;
	}

	public void calcGameResult() {
		if (userPoints >= POINTS_TO_WIN) {
			System.out.println("DU GEWINNST DAS SPIEL!");
			gameIsRunning = false;
		}
		if (pcPoints >= POINTS_TO_WIN) {
			System.out.println("DU VERLIERST DAS SPIEL!");
			gameIsRunning = false;
		}
	}
}