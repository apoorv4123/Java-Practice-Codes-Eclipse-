package Recursion;

import java.util.Scanner;

public class Scale {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int inch = scn.nextInt();
		int ticklen = scn.nextInt();

		for (int i = 0; i < inch; i++) {
			// leading inch marking
			for (int j = 0; j < ticklen; j++) {
				System.out.print("-");
			}
			System.out.println(" " + i);

			// recursive call for smaller markings
			scale(inch, ticklen);
		}
		// final inch marking
		for (int j = 0; j < ticklen; j++) {
			System.out.print("-");
		}
		System.out.println(" " + inch);

	}

	public static void scale(int inch, int ticklength) {

		if (ticklength == 0) {
			return;
		}

		scale(inch, ticklength - 1);
		// self-work
		for (int i = 0; i < ticklength - 1; i++) {
			System.out.print("-");
		}
		System.out.println();
		scale(inch, ticklength - 1);
	}
}