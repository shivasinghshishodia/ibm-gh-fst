package fst_java;

public class activity1 {
	public static void main(String[] args) {
		car toyotta = new car();
		toyotta.color = "blue";
		toyotta.make = 2026;
		toyotta.transmission = "mannual";
	
		toyotta.displaycharacterstics();
		toyotta.accelarate();
		toyotta.brake();
	}

}
