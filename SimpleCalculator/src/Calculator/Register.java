package Calculator;

public class Register {
	//Instance Variables
	String registerName;
	int value = 0;

	
	//Constructor
	public Register(String initName, int initValue) {
		registerName = initName;
		value = initValue;
	}
	
	public int getValue() {
		return value;
	}
}
