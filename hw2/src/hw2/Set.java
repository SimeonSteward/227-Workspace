package hw2;

/**
 * Models a set of games in tennis. A set consists of a sequence of games with
 * two players alternating in the role of server, known as player 0 and player
 * 1. A player wins the set by winning a minimum number of games and having at
 * least two more wins than the other player. Traditionally, the minimum number
 * is six, but in this model the number is configured in the constructor. Note
 * also that there is no "tiebreak" game when the score reaches 6-6, as occurs
 * in some traditional forms of the game.
 * 
 * @author SimeonSteward
 *
 */

public class Set {
	/**
	 * Stores the # of wins player 0 has
	 */
	private int player0GamesWon;
	
	/**
	 * Stores the # of wins player 1 has
	 */
	private int player1GamesWon;
	
	/**
	 * Stores the current server
	 */
	private int currentServer;
	
	/**
	 * Stores the # of games either player has to win to win the set, provided they lead by 2
	 */
	private int numGamesToWin;
	
	/**
	 * The Instance of TennisGame, reused after each game is done
	 */
	private TennisGame currentGame;

	/**
	 * Constructs a set with the given minimum number of games. If the parameter
	 * player1ServesFirst is true, then player 1 will be the server in the initial
	 * current game; otherwise player 0 will start out as server.
	 * 
	 * @param minimumGamesToWin  number of games needed to win the set
	 * @param player1ServesFirst true if player 1 is the server in the first game
	 */
	public Set(int minimumGamesToWin, boolean player1ServesFirst) {
		currentGame = new TennisGame();
		if (player1ServesFirst == true) {
			currentServer = 1;
		} else {
			currentServer = 0;
		}
		numGamesToWin = minimumGamesToWin;
	}

	/**
	 * Invokes serve on the current game and updates the winner's count of games won
	 * if the action ends the current game. Does nothing if the set is over or if
	 * the current game is over.
	 * 
	 * @param serviceFault true if there is a service fault, false otherwise
	 */
	public void serve(boolean serviceFault) {
		if (!currentGame.isOver()&&!isSetOver()) {
			currentGame.serve(serviceFault);
			updateWins();
		}
	}

	/**
	 * Invokes hit on the current game and updates the winner's count of games won
	 * if the action ends the current game. Does nothing if the set is over or if
	 * the current game is over.
	 * 
	 * @param fault       true if the hit results in a fault ending the rally
	 * @param outOfBounds true if the hit goes over the net but on an out of bounds
	 *                    trajectory
	 */
	public void hit(boolean fault, boolean outOfBounds) {
		if (!currentGame.isOver()&&!isSetOver()) {
			currentGame.hit(fault, outOfBounds);
			updateWins();
		}
	}

	/**
	 * Invokes miss on the current game and updates the winner's count of games won
	 * if the action ends the current game. Does nothing if the set is over or if
	 * the current game is over.
	 */
	public void miss() {
		if (!currentGame.isOver()&&!isSetOver()) {
			currentGame.miss();
			updateWins();
		}
	}

	/**
	 * Invokes setScore on the current game and updates the winner's count of games
	 * won if the action ends the current game. Does nothing if the set is over or
	 * if the current game is over. This method is intended for testing and does not
	 * check that the given scores are realistic.
	 * 
	 * @param serverScore   score to be set for the server
	 * @param receiverScore receiverScore - score to be set for the receiver
	 */
	public void fastForward(int serverScore, int receiverScore) {
		if (!(currentGame.isOver() && isCurrentGameOver())) {
			currentGame.setScore(serverScore, receiverScore);
			updateWins();
		}
	}

	/**
	 * Starts a new game in this set, switching the service to the opposite player.
	 * This method does nothing if the current game is still in progress, or if the
	 * set is over.
	 */
	public void newGame() {
		if (isCurrentGameOver() && !isSetOver()) {
			currentGame = new TennisGame();
			currentServer++;
			currentServer = Math.floorMod(currentServer, 2);
			
		}
	}

	/**
	 * Returns true if the current game is over.
	 * 
	 * @return true if the current game is over, false otherwise
	 */
	public boolean isCurrentGameOver() {
		return currentGame.isOver();
	}

	/**
	 * Returns true if the set is over. The set ends when a player has won the
	 * minimum number of games AND has won at least two games more than the other
	 * player.
	 * 
	 * @return true if the set is over, false otherwise
	 */
	public boolean isSetOver() {
		return (((player0GamesWon>=numGamesToWin)||(player1GamesWon>=numGamesToWin)) && (2<=Math.abs(player0GamesWon-player1GamesWon)));
	}

	/**
	 * Returns a string representation of the current status of the set in the form
	 * "Set: x-y Game: ss". Here x is the number of games won by the currently
	 * serving player, y is the number of games won by the other player, and ss is
	 * the score string for the current game. If the parameter useCallString is
	 * false, then the string ss is formatted as in TennisGame.getScore();
	 * otherwise, the string ss is formed according to the conventions of
	 * TennisGame.getCallString().
	 * 
	 * @param useCallString true if the score for the current game should be
	 *                      formatted according to TennisGame.getCallString()
	 * @return string representation of the set's current status
	 */
	public String getCurrentStatus(boolean useCallString) {
		int serverGamesWon;
		int receiverGamesWon;
		if (whoIsServing() == 0) {
			serverGamesWon = player0GamesWon;
			receiverGamesWon = player1GamesWon;
		} else {
			serverGamesWon = player1GamesWon;
			receiverGamesWon = player0GamesWon;
		}
		if (useCallString == false) {
			//return null;
			return "Set: " + serverGamesWon + "-" + receiverGamesWon + " Game: " + currentGame.getScore();
		} else {
			return "Set: " + serverGamesWon + "-" + receiverGamesWon + " Game: " + currentGame.getCallString();
		}
	}

	/**
	 * Returns the player (0 or 1) who is the server in the current game.
	 * 
	 * @return server in the current game
	 */
	public int whoIsServing() {
		return currentServer;
	}

	/**
	 * Returns the number of games won by player 0.
	 * 
	 * @return number of games won by player 0
	 */
	public int player0GamesWon() {
		return player0GamesWon;
	}

	/**
	 * Returns the number of games won by player 1.
	 * 
	 * @return number of games won by player 1
	 */
	public int player1GamesWon() {
		return player1GamesWon;
	}
	private void updateWins() {
		if (currentGame.isOver()) {
			if ((currentGame.serverWon()) && (currentServer == 0) || (currentGame.receiverWon()) && (currentServer == 1)) {
				player0GamesWon++;
			} else {
				player1GamesWon++;
			}
		}
	}
}
