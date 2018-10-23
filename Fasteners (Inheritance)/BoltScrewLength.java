//Bolts and screws have same length range specifications and thus have been placed in a 
//separate class than nails, before their respective categories. 
public class BoltScrewLength extends HasLength {

	// tried to create a function that does this but ran into too many errors, and
	// it proved to be
	// difficult for some reason
	private double[] lengths = { 0.5, 0.75, 1, 1.25, 1.5, 1.75, 2, 2.25, 2.5, 2.75, 3, 3.25, 3.5, 3.75, 4, 4.25, 4.5,
			4.75, 5, 5.25, 5.5, 5.75, 6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5, 11, 12, 13, 14, 15, 16, 17, 18, 19,
			20 };

	public BoltScrewLength(String material, String finish, double unitPrice, int noUnits, String thread, double length)
			throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, thread, length);
		if (illegalCheck(lengths, length))
			throw new IllegalFastener("Illegal length!");
	}

}
