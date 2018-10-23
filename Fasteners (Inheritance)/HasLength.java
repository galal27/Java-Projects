//HasLength covers nails, screws and bolts since nuts don't have length. Length introduced here.
public class HasLength extends Fastener {

	private double length;

	// Constructor to allow for items that include thread.
	public HasLength(String material, String finish, double unitPrice, int noUnits, String thread, double length)
			throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, thread);
		this.length = length;
	}

	// Overridden constructor for items that don't have thread.
	public HasLength(String material, String finish, double unitPrice, int noUnits, double length)
			throws IllegalFastener {
		super(material, finish, unitPrice, noUnits);
		this.length = length;
	}

	public String toString() {
		return length + "\" long." + super.toString();
	}
}
