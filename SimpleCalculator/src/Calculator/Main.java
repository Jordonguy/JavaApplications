package Calculator;

import java.util.Scanner;

public class Main { //Neaten the code up into separate classes and call the methods
	
	//Initialising Variables
			public static Scanner inputScanner = new Scanner(System.in); //User input scanner
			public static String inputtedRegister; //Users selected Register to do calculations on
			public static String operationChosen = null; //Users chosen operation
			public static String input = null; //Users choice to Print(Compute Calculations) or to add another calculation
			public static int valueInputted;
			public static int tempInt;

	public static void main(String[] args) {
		do {
		registerInput();
		operationInput();
		valueInput();
		calculate();
		userChoice();
		} while (input != "Quit");
		quit();
		}
	
		private static void quit() {
			System.out.println("Application Terminated");
			//Closing the java program when the user inputs exit into the input scanner.
			inputScanner.close(); // closing the scanner
			System.exit(0); // terminating the program
		
	}


		private static void calculate() {
			try {
				Register newRegister = new Register(inputtedRegister, 0);
				switch(operationChosen) {
				case "+":
					newRegister.value = newRegister.value + valueInputted;
					System.out.println("The value of " + inputtedRegister + " is " + newRegister.value);
					break;
				case "-":
					newRegister.value = newRegister.value - valueInputted;
					System.out.println("The value of " + inputtedRegister + " is " + newRegister.value);
					break;
				case "*":
					newRegister.value = newRegister.value * valueInputted;
					System.out.println("The value of " + inputtedRegister + " is " + newRegister.value);
					break;
					default:
						System.out.println("Illigal Operation");
				}
				} catch(Exception e) {
					System.err.println(e.getMessage());
				}
		
	}


		private static void userChoice() {
			try {
			System.out.println("To add another calculation input a register.");
			System.out.println("Or type Quit to terminate the application");
			input = inputScanner.nextLine();
			input = inputScanner.nextLine();
			System.out.println(input);
			if(input.contentEquals("Quit")) {
				quit();
			}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
	}

		private static void registerInput() {
			try { //Asking the User to choose a register to do a calculation for
				System.out.println("Please Input the first value (Register)");
				inputtedRegister = inputScanner.nextLine();
				System.out.println("Selected Register is " + inputtedRegister);	
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
		
	}
		private static void operationInput() {
			try { //Asking the user to choose the operation they want
				System.out.println("Please Select an Operation:");
				System.out.println("+ Addition");
				System.out.println("- Subtraction");
				System.out.println("* Multiplication");
				operationChosen = inputScanner.nextLine();
			switch(operationChosen) {
			case "+":
				System.out.println("1. Addition Selected");
				break;
			case "-":
				System.out.println("2. Subtraction Selected");
				break;
			case "*":
				System.out.println("3. Multiplication Selected");
				break;
				default:
					System.out.println("Illigal Operation");
					operationInput();
			} } catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
			private static void valueInput() {
				try { //Asking the user what value they want.
					System.out.println("Please input a value.");
					valueInputted = inputScanner.nextInt();
					System.out.println("The value inputted is now " + valueInputted);
					} catch (Exception e){
						 System.err.println(e.getMessage());
					}
			}	
	}
