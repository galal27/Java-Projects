//CommonNail class includes value range specifications and checks for errors. 
public class CommonNail extends Nail {

	private String size;
	private String[] sizes = { "6D", "8D", "10D", "12D", "16D", "60D" };
	private double[] lengths = { 2, 2.5, 3, 3.25, 3.5, 6 };
	private double[] guages = { 2, 8, 9, 10.25, 11.5 };

	public CommonNail(String material, String finish, double unitPrice, int noUnits, String thread, double length,
			double guage, String s) throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, length, guage);
		if (material != "Steel")
			throw new IllegalFastener("Illegal material, nails must be steel!");
		if (illegalCheck(lengths, length))
			throw new IllegalFastener("Illegal length!");
		if (illegalCheck(guages, guage))
			throw new IllegalFastener("Illegal guage!");
		if (illegalCheck(sizes, size))
			throw new IllegalFastener("Illegal size!");
		if (finish != "Bright" && finish != "Hot Dipped" && finish != "Galvanized")
			throw new IllegalFastener("Illegal finish");
		size = s;
	}

	public String toString() {
		return "Common Nail, " + size + " size. " + super.toString();
	}

}
