package versionZero.modele;

import java.nio.ByteBuffer;

public class Utils {
	// FONCTIONNEL
	public static byte[] stringToBytes(String str) {
		char[] buffer = str.toCharArray();
		byte[] b = new byte[buffer.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) buffer[i];
		}
		return b;
	}
	
	// FONCTIONNEL
	public static byte[] intToBytes(int val) {
		return ByteBuffer.allocate(4).putInt(val).array();
	}
	
	// FONCTIONNEL
	public static int extractIntFrom(byte[] data, int offset) {
		byte[] intTab = new byte[4];
		
		// Recuperation de l'int
		for(int i=0; i<4; i++) {
			intTab[i] = data[offset+i];
		}
		int res = intTab[3];
		res |= intTab[2]<<8;
		res |= intTab[1]<<16;
		res |= intTab[0]<<24;
		
		return res;
	}
	
	// FONCTIONNEL
	public static char[] bytesToChars(byte[] tab) {
		char[] newTab = new char[tab.length];
		for(int i=0; i<tab.length; i++) {
			newTab[i] = (char) tab[i];
		}
		return newTab;
	}
}
