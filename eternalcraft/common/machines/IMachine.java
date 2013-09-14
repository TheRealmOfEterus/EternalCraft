package eternalcraft.common.machines;

/**
 * 
 * @author bau5
 *
 */
public interface IMachine {
	/**
	 * Method to get the direction the machine is facing, used for renders.
	 * 
	 * @return direction
	 */
	byte getDirectionFacing();
	/**
	 * Method to set the direction the machine is facing. Handled by BlockECContainer typically.
	 * @param dir
	 */
	void setDirectionFacing(byte dir);
	/**
	 * Gets the type of machine
	 * @return machine type
	 */
	MachineType getMachineType();
	/**
	 * Gets the activity state of the machine.
	 * @return state
	 */
	boolean isActive();
}
