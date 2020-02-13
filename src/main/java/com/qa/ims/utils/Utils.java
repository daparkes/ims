package com.qa.ims.utils;

import java.util.Scanner;

/**
 * A Utils class with just one method, getInput(), which is a wrapper for a Scanner
 * object.
 * @author Dan
 *
 */
public class Utils {

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
