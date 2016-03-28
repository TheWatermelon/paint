package ca.uds.jfig.application;
/**
 * 
 */

/**
 * @author Aymeric Birotheau
 * @date 18/04/2013
 *
 */

import java.util.prefs.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SavePreferences {
	Preferences prefs = Preferences.userNodeForPackage(SavePreferences.class);

	public int[] setInitalState() throws Exception {
		int[] state = new int[4];
		state[0] = prefs.getInt("x", 200);
		state[1] = prefs.getInt("y", 200);
		state[2] = prefs.getInt("w", 100);
		state[3] = prefs.getInt("h", 100);

		return state;
	}

	public void saveFramePositions(int getX, int getY, int getWidth,
			int getHeight) {
		prefs.putInt("x", getX);
		prefs.putInt("y", getY);
		prefs.putInt("w", getWidth);
		prefs.putInt("h", getHeight);
	}

	@Test
	public void SavePreferencesTest() {

		saveFramePositions(200, 100, 50, 12);
		try {
			int[] state = setInitalState();
			assertEquals("SavePreferencesTest", state[0], 200);
			assertEquals("SavePreferencesTest", state[1], 100);
			assertEquals("SavePreferencesTest", state[2], 50);
			assertEquals("SavePreferencesTest", state[3], 12);
			prefs.putInt("x", 300);
			prefs.putInt("y", 300);
			prefs.putInt("w", 500);
			prefs.putInt("h", 500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
