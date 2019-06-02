
import java.util.Scanner;

public class Univ_Elevator {
	boolean isOpen = false; // Class variables
	int currentFloor = 0; // Elevator starts at basement level

	// Method to be executed when called
	int Up(int toFloor) { // toFloor is a variable to pass parameters into when method is called. Use
							// scanner for parameters
		if ((toFloor > currentFloor) && (toFloor < 2)) {

			u();   //calling another method of the class

		} else if (toFloor == 2) {
			u2(); 
		}
		else
			System.out.println("Staying at " + currentFloor + " floor"); //user error

		return currentFloor;  //return same type as method

	}

	private void up() { // private method of this class
		if (currentFloor < 2) {
			currentFloor++;
			System.out.println("Going to,,, " + currentFloor);
		} else {
			System.out.println("Staying at " + currentFloor);
		}
	}

	private void openDoor() {   //door method
		isOpen = true;
		System.out.println("Door opened");
		
		// This makes the code wait for 2 seconds (chapter 11)
				try {
					Thread.sleep(2000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// End of wait code.
	}

	private void closeDoor() {
		isOpen = false;
		System.out.println("Door closed");
	}

	public void u() { //method to be used in 'main' which calls the local private method up()
		up();
		openDoor();
		closeDoor();
	}

	public void u2() {
		up();
		up();
		openDoor();
		closeDoor();
	}

	private void down() {  
		if (currentFloor > 0) {
			currentFloor--;
			System.out.println("Going to,,, " + currentFloor);
		} else {
			System.out.println("Staying at " + currentFloor);
		}
	}

	public void d() {
		down();
		openDoor();
		closeDoor();
	}

	public void d2() {
		down();
		down();
		openDoor();
		closeDoor();
	}

	public static void main(String[] args) // main method
	{

		System.out.print("Which floor are you going to?\n\t");
		Scanner scan = new Scanner(System.in);

		int choice = scan.nextInt(); // will scan what floor the user will go to, pass it to toFloor

		
		Univ_Elevator E = new Univ_Elevator(); // creates an object ( univ elevator) of the class Elevator

	 
	    int returnedFLoor = E.Up(choice); // call method
		
		
	}
}