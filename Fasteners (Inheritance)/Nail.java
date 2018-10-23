//Class for all nails, introduces guage. 
public class Nail extends HasLength {

	private double guage;

	public Nail(String material, String finish, double unitPrice, int noUnits, double length, double guage)
			throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, length);
		if (material != "Steel")
			throw new IllegalFastener("Illegal material, nails must be steel!");
		this.guage = guage;
	}

	public String toString() {
		return guage + " guage. " + super.toString();
	}

}
