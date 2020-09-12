package hw1;

/**
 * This is a simple model of ink usage and paper usage of a printer
 * @author SimeonSteward
 *
 */
public class Printer {
	/**
	 * Capacity, in ounces, of a new ink cartridge.
	 */
	public static final double INK_CAPACITY = 2.0;

	/**
	 * Amount of ink, in ounces, used per printed page.
	 */
	public static final double INK_USAGE = 0.0023;
	/**
	 * Stores capacity of the printer
	 */
	private int capacity;
	/**
	 * Stores the current paper in the printer
	 */
	private int currentPaper;
	/**
	 * Stores the current Ink, in ounces in the printer
	 */
	private double currentInk;
	/**
	 * Stores the paper used in the history of the printer
	 */
	private int paperUsed;
	/**
	 * Stores the actual amount of pages printed after checking whether the printer
	 * has enough ink and paper to print
	 */
	private int actuallyUsed;

	/**
	 * Constructs a printer that has the given capacity (number of sheets of paper
	 * it can hold). Initially it contains no paper and a full ink cartridge.
	 * 
	 * @param givenCapacity the number of sheets the printer can hold
	 */
	public Printer(int givenCapacity) {
		capacity = givenCapacity;
		currentPaper = 0;
		currentInk = INK_CAPACITY;
		paperUsed = 0;

	}

	/**
	 * Constructs a printer that has the given capacity (number of sheets of paper
	 * it can hold). Initially it contains the given number of sheets of paper and a
	 * full ink cartridge.
	 * 
	 * @param givenCapacity       the number of sheets the printer can hold
	 * @param givenNumberOfSheets the printer has when it is initialized
	 */
	public Printer(int givenCapacity, int givenNumberOfSheets) {
		capacity = givenCapacity;
		currentPaper = Math.min(givenNumberOfSheets, capacity);
		currentInk = INK_CAPACITY;
		paperUsed = 0;
		
	}

	/**
	 * Adds the given number of sheets of paper to this printer, not exceeding the
	 * printer's capacity.
	 * 
	 * @param additionalSheets the number of additional sheets added to the printer
	 */
	public void addPaper(int additionalSheets) {
		currentPaper = Math.min(additionalSheets + currentPaper, capacity);
	}

	/**
	 * Returns the number of sheets of paper currently in this printer. This value
	 * is never negative.
	 * 
	 * @return the current amount of paper in the printer
	 */
	public int getCurrentPaper() {
		return currentPaper;
	}

	/**
	 * Returns the total number of sheets of paper printed by this printer since its
	 * construction. Note this is counting sheets of paper, not pages printed, i.e.
	 * sheets used for two sided printing still count as just one sheet.
	 * 
	 * @return the total number of sheets of paper printed by this printer since its
	 *         construction
	 */
	public int getTotalPaperUse() {
		return paperUsed;
	}

	/**
	 * Determines whether the ink has run out. Returns true if the amount of ink
	 * left is smaller than the quantity INK_USAGE needed to print one page.
	 * 
	 * @return whether the Ink is out
	 */
	public boolean isInkOut() {
		return (INK_USAGE >= currentInk);
	}

	/**
	 * Simulates replacement of the ink cartridge, restoring the quantity of ink in
	 * the printer to INK_CAPACITY
	 */
	public void replaceInk() {
		currentInk = INK_CAPACITY;
	}

	/**
	 * Simulates printing pages in one-sided mode, using the appropriate number of
	 * sheets and a corresponding quantity of ink. If there is not enough paper, the
	 * printer will use up all remaining paper and will only use the quantity of ink
	 * needed for the sheets actually printed. If there is not enough ink, the
	 * printer will use up all the ink, and will still use up the specified number
	 * of sheets of paper (i.e., it just prints a bunch of blank pages after the ink
	 * runs out).
	 * 
	 * @param numberOfPages the number of pages it attempts to print
	 */
	public void print(int numberOfPages) {

		actuallyUsed = Math.min(numberOfPages, currentPaper);
		currentInk = currentInk - (INK_USAGE * actuallyUsed);
		currentPaper = currentPaper - actuallyUsed;
		paperUsed = paperUsed + actuallyUsed;

	}

	/**
	 * Simulates printing pages in two-sided mode, using the appropriate number of
	 * sheets and a corresponding quantity of ink. If there is not enough paper, the
	 * printer will use up all remaining paper and will only use the quantity of ink
	 * needed for the sheets actually printed. If there is not enough ink, the
	 * printer will use up all the ink, and will still use up the specified number
	 * of sheets of paper (i.e., it just prints a bunch of blank pages after the ink
	 * runs out).
	 * 
	 * @param numberOfPages the number of pages it attempts to print
	 */
	public void printTwoSided(int numberOfPages) {
		actuallyUsed = Math.min((numberOfPages / 2) + (numberOfPages % 2), currentPaper);
		currentInk = currentInk - (INK_USAGE * actuallyUsed * 2);
		currentPaper = currentPaper - actuallyUsed;
		paperUsed = paperUsed + actuallyUsed;
	}
}
