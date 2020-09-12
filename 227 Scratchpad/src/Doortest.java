
public class Doortest {
	public static void main(String[] args) {
	Door d = new Door();
	System.out.println(d.isOpen());
	System.out.println("Expected: true");
	d.closeDoor();
	System.out.println(d.isOpen());
	System.out.println("Expected: false");
	d.openDoor();
	System.out.println(d.isOpen());
	System.out.println("Expected: true");
	}
}
 