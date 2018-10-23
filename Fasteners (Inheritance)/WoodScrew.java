//WoodScrew class includes value range specifications and checks for errors. 
public class WoodScrew extends Screw {

	private String[] points = { "Double Cut", "Sharp", "Type 17" };

	public WoodScrew(String material, String finish, double unitPrice, int noUnits, String thread, double length,
			String head, String drive, String point) throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, thread, length, head, drive, point);
		if (illegalCheck(points, point))
			throw new IllegalFastener("Illegal point!");
	}

	public String toString() {
		return "Wood Screw, " + super.toString();
	}
}
