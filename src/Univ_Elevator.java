
import java.util.Scanner;

//The following code executes the University Elevator always returning it to the basement level.
//Open loop to always scan the users destination, one after the other.
public class Univ_Elevator {
	boolean isOpen = false; // Class variables
	int currentFloor = 0; // Elevator starts at basement level
	int returnedFloor = currentFloor;

	// Method to be executed when called
	int Direction(int toFloor) { // toFloor is a variable to pass parameters into when method is called. Use
	                            // scanner for parameters. This loop always returns the elevator to the basement level.
								

		if ((toFloor > currentFloor) && (toFloor < 2))

		{

			u(); // calling another method of the class

		} else {
			u2();
		}

		if ((toFloor < currentFloor) && (toFloor > 0)) {
			d();

		} else {
			d2();
		}

		return currentFloor; // return same type as method

	}

	void up() {
		if (currentFloor < 2) {
			currentFloor++;
			System.out.println("Going to the,,, " + currentFloor + " floor");

		} else {
			System.out.println("Staying at the" + currentFloor + " floor");

		}
	}

	void openDoor() {
		isOpen = true;
		System.out.println("Door is opening");

		// This makes the code wait for 2 seconds (chapter 11)
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// End of wait code.
	}

	void down() {
		if (currentFloor > 0) {
			currentFloor--;
			System.out.println("Going to,,, " + currentFloor);
		} else {
			System.out.println("Staying at " + currentFloor);
		}
	}

	void closeDoor() {
		isOpen = false;
		System.out.println("Door is closing");
	}

	public void u() { // method to be used in 'main' which calls the local method up() which has the 'mecánica'
						
		up();
		openDoor();
		closeDoor();
	}

	public void u2() {
		up();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		up();
		openDoor();
		closeDoor();
	}

	public void d() {
		down();
		openDoor();
		closeDoor();
	}

	public void d2() {
		down();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		down();
		openDoor();
		closeDoor();
	}

	public static void main(String[] args) // main method
	{

		System.out.print("Which floor are you going to: 0 1 2?\n\t");
		Scanner scan = new Scanner(System.in);

		int choice = scan.nextInt(); // will scan what floor the user will go to, pass it to toFloor

		Univ_Elevator E = new Univ_Elevator(); // creates an object ( univ elevator) of the class Elevator

		E.Direction(choice); // call method

		while ((choice = scan.nextInt()) != 0) {
			E.Direction(choice);
		}
	}
}
