/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @date 29/04/2013
 *
 */
package ca.uds.jfig.menu;
public class Invoker {

	Command command;

	public Invoker(Command command) {
		this.command = command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void invoke() {
		command.execute();
	}
}
