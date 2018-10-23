//Class for all screws, doesn't introduce anything but added for versatility for future item additions.
public class Bolt extends BoltScrewLength {

	public Bolt(String material, String finish, double unitPrice, int noUnits, String thread, double length)
			throws IllegalFastener {
		super(material, finish, unitPrice, noUnits, thread, length);
	}

}
