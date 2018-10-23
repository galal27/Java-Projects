//No separate class for Nuts because it was not specified if Nuts had all fields like WingNut - 
//unlike with other classes of fasteners.
public class WingNut extends Fastener {

	public WingNut(String material, String finish, double unitPrice, int noUnits, String thread)
			throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, thread);
	}

	public String toString() {
		return "Wing Nut, " + super.toString();
	}
}
