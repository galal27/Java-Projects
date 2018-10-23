//Class for all screws, introduces head, drive and point.
public class Screw extends BoltScrewLength {

	private String head;
	private String drive;
	private String point;
	private String[] heads = { "Bugle", "Flat", "Oval", "Pan", "Round" };
	private String[] drives = { "6-Lobe", "Philips", "Slotted", "Square" };
	private String[] finishSteelScrews = { "Chrome", "Hot Dipped Galvanized", "Plain", "Yellow Zinc", "Zinc",
			"Black Phosphate", "ACQ 1000 Hour", "Lubricated" };

	public Screw(String material, String finish, double unitPrice, int noUnits, String thread, double length, String h,
			String d) throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, thread, length);
		if (illegalCheck(heads, head))
			throw new IllegalFastener("Illegal head!");
		if (illegalCheck(drives, drive))
			throw new IllegalFastener("Illegal drive!");
		if (material == "Steel") {
			if ((illegalCheck(finishSteelScrews, finish)))
				throw new IllegalFastener("Illegal finish!");
		}
		if (material != "Steel")
			if (finish == "Black Phosphate" || finish == "ACQ 1000 Hour" || finish == "Lubricated")
				throw new IllegalFastener("Illegal finish for non-steel screws");
		head = h;
		drive = d;
	}

	public Screw(String material, String finish, double unitPrice, int noUnits, String thread, double length, String h,
			String d, String p) throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, thread, length);
		if (illegalCheck(heads, head))
			throw new IllegalFastener("Illegal head!");
		if (illegalCheck(drives, drive))
			throw new IllegalFastener("Illegal drive!");
		head = h;
		drive = d;
		point = p;
	}

	public String toString() {
		return point + " point, " + head + " head, " + drive + " drive. " + super.toString();
	}

}
