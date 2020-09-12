package hw2;

import java.lang.*;
import static hw2.BallDirection.*;

/**
 * Models a game of tennis. There are two players, a server and a receiver,
 * whose roles remain the same throughout the game. The server hits or serves
 * the ball toward the receiver. If the server makes an error in serving the
 * ball, called a service fault, then the ball is served again. However, if
 * there are two service faults in a row, the receiver is awarded a point and
 * the server starts again with the count of faults reset to zero. As soon as
 * the ball is served without a service fault, it is said to be in play, and a
 * rally begins in which the players hit the ball back an forth towards one
 * another. The rally ends when either one of them faults in some way, e.g.,
 * allows the ball to bounce twice, hits the ball into the net or the ceiling or
 * something, or one of them hits the ball on an out-of-bounds trajectory, and
 * the other player does not try to hit it back before it bounces, allowing it
 * to land out of bounds The game ends when one player has more than three
 * points with a margin of at least two points more than the other player.
 * 
 * @author SimeonSteward
 *
 */
public class TennisGame extends java.lang.Object {
	/**
	 * Stores the receiver's points in this game
	 */
	private int receiverPoints;
	
	/**
	 * Stores the server's points in this game
	 */
	private int serverPoints;
	
	/**
	 * Stores the ball's current status
	 */
	private BallDirection ballStatus;
	
	/**
	 * Stores the server's faults in this game
	 */
	private int faults = 0;
	
	/**
	 * Stores whether the ball is headed out of bounds
	 */
	private boolean headedOutOfBounds = false;

	/**
	 * Constructs a new TennisGame in which both players have zero points and the
	 * ball is initially not in play.
	 */
	public TennisGame() {
		receiverPoints = 0;
		serverPoints = 0;
		ballStatus = NOT_IN_PLAY;
	}

	/**
	 * Directly sets the scores to the given amounts and sets the ball's status to
	 * NOT_IN_PLAY. Note that this operation may cause the scores to go down, or
	 * result in unrealistic values. This method is intended for testing only.
	 * 
	 * @param newServerScore   new score for the server
	 * @param newReceiverScore new score for the receiver
	 */
	public void setScore(int newServerScore, int newReceiverScore) {
		serverPoints = newServerScore;
		receiverPoints = newReceiverScore;
		ballStatus = NOT_IN_PLAY;
	}

	/**
	 * Returns the current number of points for the receiver.
	 * 
	 * @return current number of points for the receiver
	 */
	public int getReceiverPoints() {
		return receiverPoints;
	}

	/**
	 * Returns the current number of points for the server.
	 * 
	 * @return current number of points for the server
	 */
	public int getServerPoints() {
		return serverPoints;
	}

	/**
	 * Returns the current status of the ball (traveling toward the receiver,
	 * traveling toward the server, or not in play).
	 * 
	 * @return current status of the ball
	 */
	public BallDirection getBallStatus() {
		return ballStatus;
	}

	/**
	 * Returns true if the game is over, which occurs when one player has more than
	 * three points AND has a margin of at least two points over the other player.
	 * 
	 * @return true if the game is over, false otherwise
	 */
	public boolean isOver() {
		if (((serverPoints > 3) || (receiverPoints > 3)) && (Math.abs(serverPoints - receiverPoints) >= 2)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the game is over and the server has won.
	 * 
	 * @return true if the server has won the game, false otherwise
	 */
	public boolean serverWon() {
		if (isOver() && (serverPoints > receiverPoints)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the game is over and the receiver has won.
	 * 
	 * @return true if the receiver has won the game, false otherwise
	 */
	public boolean receiverWon() {
		if (isOver() && (serverPoints < receiverPoints)) {
			return true;
		}
		return false;
	}

	/**
	 * Simulates the server serving the ball. If the serviceFault parameter is
	 * false, then the ball's status will be TOWARD_RECEIVER. If the serviceFault
	 * parameter is true, the number of faults is incremented, and if the number of
	 * faults reaches two, it is reset to zero and a point is awarded to the
	 * receiver. This method does nothing if the game is over or if the ball status
	 * isn't NOT_IN_PLAY.
	 * 
	 * @param serviceFault true if there is a service fault, false otherwise
	 */
	public void serve(boolean serviceFault) {
		if (!isOver() && ballStatus == NOT_IN_PLAY) {
			if (serviceFault == false) {
				ballStatus = TOWARD_RECEIVER;
				headedOutOfBounds = false;
				faults = 0;
			} else {
				faults++;
				if (faults == 2) {
					faults = 0;
					receiverPoints++;
				}
			}
		}

	}

	/**
	 * Simulates a hit of the ball by the player toward whom the ball is currently
	 * moving. If the fault parameter is true, indicates that the hit results in a
	 * fault; then the rally ends with the other player getting a point, and the
	 * ball's status becomes NOT_IN_PLAY. If the fault parameter is false, then the
	 * ball's status just switches direction. The outOfBounds parameter indicates
	 * whether or not the trajectory of the ball would land it out of bounds, if the
	 * other player misses it. (The other player could elect to hit the ball before
	 * it bounces.) This method does nothing if the ball is not in play.
	 * 
	 * @param fault             true if this hit ends the rally
	 * @param headedOutOfBounds true if the hit is not a fault but is on an
	 *                          out-of-bounds trajectory
	 */
	public void hit(boolean fault, boolean headedOutOfBounds) {
		if (ballStatus != NOT_IN_PLAY) {
			if (fault == true) {
				if (ballStatus == TOWARD_SERVER) {
					receiverPoints++;
				} else {
					serverPoints++;
				}
				ballStatus = NOT_IN_PLAY;
			} else {
				if (ballStatus == TOWARD_SERVER) {
					ballStatus = TOWARD_RECEIVER;
				} else {
					ballStatus = TOWARD_SERVER;
				}

				if (headedOutOfBounds == true) {
					this.headedOutOfBounds = true;
				} else {
					this.headedOutOfBounds = false;
				}
			}
		}
	}

	/**
	 * Simulates a miss of the ball by the player toward whom the ball is currently
	 * traveling. If the ball is on an out-of-bounds trajectory, that player gets a
	 * point, otherwise the other player gets a point. This method always ends the
	 * rally, i.e., after this method executes, the ball is no longer in play. This
	 * method does nothing if the ball is not in play.
	 */
	public void miss() {
		if (ballStatus != NOT_IN_PLAY) {
			if (((ballStatus == TOWARD_RECEIVER) && (headedOutOfBounds == true)) || ((ballStatus == TOWARD_SERVER) && (headedOutOfBounds == false))) {
				receiverPoints++;
			} else {
				serverPoints++;
			}
			ballStatus = NOT_IN_PLAY;
		}
	}

	/**
	 * Returns a string representation of the raw points for each player, in the
	 * form "x-y" where x is the number of points for the server and y is the number
	 * of points for the receiver.
	 * 
	 * @return string representation of the score
	 */
	public String getScore() {
		return (serverPoints + "-" + receiverPoints);

	}

	/**
	 * Returns a string representation of the score using the bizarre conventions of
	 * tennis. If the game is over, the returned string is always of the form "x-y",
	 * where x is the server's score and y is the receiver's score. When the game is
	 * not over, the following rules apply:
	 * 
	 * @return
	 */
	public String getCallString() {
		if (isOver()) {
			return getScore();
		} else {
			if ((serverPoints >= 4) && (serverPoints - receiverPoints == 1)) {
				return "advantage in";
			} else if ((receiverPoints >= 4) && (receiverPoints - serverPoints == 1)) {
				return "advantage out";
			} else if ((receiverPoints >= 3) && (receiverPoints == serverPoints)) {
				return "deuce";
			} else if (receiverPoints == serverPoints) {
				return convertToTennisLingo(receiverPoints) + "-all";
			} else {

				return convertToTennisLingo(serverPoints) + "-" + convertToTennisLingo(receiverPoints);
			}
		}

	}

	private String convertToTennisLingo(int toConvert) {
		switch (toConvert) {
		case 0:
			return "love";
		case 1:
			return "15";
		case 2:
			return "30";
		case 3:
			return "40";
		default:
			return null;
		}
	}
}
