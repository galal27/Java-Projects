//Exception thrown by objects if parameters are not legal.
public class IllegalFastener extends Exception {

	private static final long serialVersionUID = 4705089863030936649L;

	public IllegalFastener() {
		super("Illegal parameter value supplied to Fastener object.");
	}

	public IllegalFastener(String message) {
		super(message);
	}

}
