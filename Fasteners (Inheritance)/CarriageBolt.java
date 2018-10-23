//CarriageBolt didn't have any particular specifications and thus only includes simple constructor 
//and toString method.
public class CarriageBolt extends Bolt {

	public CarriageBolt(String material, String finish, double unitPrice, int noUnits, String thread, double length)
			throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, thread, length);
	}

	public String toString() {
		return "Carriage Bolt, " + super.toString();
	}
}
