package com.etienne;


/**
 * Created by Etienne KOA
 */

public class DogMain {

	public static void main(String[] args) {

		Labrador rover = new Labrador("Rover");
		Dog rover2 = new Dog("Rover");

		System.out.println(rover2.equals(rover2));
		System.out.println(rover.equals(rover2));

	}
}
