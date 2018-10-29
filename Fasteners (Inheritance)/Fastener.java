//The hierarchy was created to be versatile and includes classes/hierarchy stages that may not have been 
//necessary for this assignment but would allow for good organization when adding more items than 
//those that have been requested.
//Of course a UML diagram could be generated but I have created a tree diagram for your convenience.

/*
 * 
 * 									Fasteners
 * 								/				\
 * 							HasLength			WingNut
 * 							/		\
 * 						Nail		BoltScrewLength
 * 						/				\		\
 * 					CommonNail			Screw	Bolt
 * 										/		\
 * 									WoodScrew	CarriageBolt
 */
public class Fastener {
	private String material;
	private String finish;
	private double unitPrice;
	private int noUnits;
	private String thread;

	// arrays consist of possible attributes as specified in assignment brief
	private String[] threads = { "#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18", "3/8-16",
			"7/16-14", "1/2-13", "5/8-11", "3/4-10" };
	private String[] materials = { "Brass", "Stainless Steel", "Steel" };
	private String[] finishBrassSS = { "Plain" };
	private String[] finishSteel = { "Chrome", "Hot Dipped Galvanized", "Plain", "Yellow Zinc", "Zinc" };

	// Method to check for illegal string values
	public boolean illegalCheck(String[] array, String s) {
		boolean err = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == s) {
				err = false;
				return err;
			}
		}
		return err;
	}

	// Overrides method to check for illegal double values
	public boolean illegalCheck(double[] array, double s) {
		boolean err = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == s) {
				err = false;
				return err;
			}
		}
		return err;
	}

	// Constructor for fasteners throws IllegalFastener if there are errors
	public Fastener(String material, String finish, double unitPrice, int noUnits, String thread)
			throws IllegalFastener {

		if (material == null)
			throw new IllegalFastener("Material should not be null! Enter a material");

		if (noUnits < 1 || noUnits > 1000) {
			throw new IllegalFastener("Illegal number of units!");
		} else {
			if (noUnits > 1 && (noUnits % 5) != 0)
				throw new IllegalFastener("Illegal number of units!");
		}
		if (illegalCheck(threads, thread))
			throw new IllegalFastener("Illegal thread size!");

		if (illegalCheck(materials, material))
			throw new IllegalFastener("Illegal material!");

		if (material == "Steel") {
			if (illegalCheck(finishSteel, finish))
				throw new IllegalFastener("Illegal finish!");
		} else {
			if (illegalCheck(finishBrassSS, finish))
				throw new IllegalFastener("Illegal finish!");
		}

		// Initialize object if error free
		this.material = material;
		this.finish = finish;
		this.unitPrice = unitPrice;
		this.noUnits = noUnits;
		this.thread = thread;

	}

	// Overrides fastener constructor to allow for no thread.
	public Fastener(String material, String finish, double unitPrice, int noUnits) throws IllegalFastener {

		if (illegalCheck(materials, material))
			throw new IllegalFastener("Illegal material!");

		if (material == "Steel") {
			if (illegalCheck(finishSteel, finish))
				throw new IllegalFastener("Illegal finish!");
		} else {
			if (illegalCheck(finishBrassSS, finish))
				throw new IllegalFastener("Illegal finish!");
		}

		if (noUnits < 1 || noUnits > 1000 || (noUnits % 5) != 0)
			throw new IllegalFastener("Illegal number per unit!");

		this.material = material;
		this.finish = finish;
		this.unitPrice = unitPrice;
		this.noUnits = noUnits;
	}

	// Accessor to get total cost of an order, as requested in assignment brief
	public double getOrderCost(int noUnits) {
		return noUnits * unitPrice;
	}

	// toString method to make sense of an item
	public String toString() {
		return thread + " thread, " + material + ", with a " + finish + ". " + noUnits + " in a unit, $" + unitPrice
				+ "per unit.";
	}

}
