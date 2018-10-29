package model;


/**
 * Part of the solution for a previous project. An exception class used by both Pizza and LineItem.
 */
public class IllegalPizza extends Exception {

	private static final long serialVersionUID = 4593713417540203652L;

	/**
	 * The exception class' constructor.
	 * @param message A message describing the error.
	 */
	public IllegalPizza (String message) {
		super(message);
	} // end constructor
	
} // end IllegalPizza class
