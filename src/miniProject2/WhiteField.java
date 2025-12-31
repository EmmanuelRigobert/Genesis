package miniProject2;

/**
 * Implements a white field.
 * 
 * @author Marcus
 */
public class WhiteField extends Field{
	/**
	 * Creates a new field at the specified position.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 */

	/**
	 * Creates a new field at the specified position.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 */
 // TODO: change inheritance hierarchy

	/**
	 * Creates a new white field at the specified position.
	 * 
	 * @param x The x coordinate of the position.
	 * @param y The y coordinate of the position.
	 */
	// TODO: constructor
	public WhiteField(int x, int y) {
		super(x, y);
	}
	/**
	 * Returns the string "w".
	 * 
	 * @return The string "w".
	 */
	// TODO: override getColor
	@Override
	public String getColor(){
		return "w";
	}
	
	
}
