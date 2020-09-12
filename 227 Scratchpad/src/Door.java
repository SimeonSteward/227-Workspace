/**
 * Simple code to model a door
 * @author SimeonSteward
 *
 */
public class Door {
	private boolean doorState;
	public void openDoor() {
		doorState = true;
	}
	/**
	 * Opens door
	 */
	public void closeDoor() {
		doorState = false;
	}
	/**
	 * closes door
	 */
	public boolean isOpen() {
				return doorState;
	}
	/**
	 * Determines whether the door is open
	 * Returns true if door is open otherwise false
	 */
	
	public Door(){
		doorState = true;
	}
	/**
	 * Constructs a door initialized as open
	 */
}
