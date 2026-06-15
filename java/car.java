package fst_java;

public class car {
	String color;
	int make;
	String transmission;
	int tyres;
	int door;
	
	car(){
		tyres = 4;
		door = 4;
	}
	
	public void displaycharacterstics() {
		System.out.println("The color of the car is"+ color);
		System.out.println("The transmission of the car is"+ transmission);
		System.out.println("The car was made in"+make);
		System.out.println("The number of tyres are"+tyres);
		System.out.println("The number of doors are"+door);
	}
		
	public void accelarate() {
		System.out.println("Car is moving forward");
	}
		
	public void brake() {
		System.out.println("The car has stopped");
		
	}

}
