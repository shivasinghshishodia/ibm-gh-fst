package fst_java;

class Human {
	static int humancount = 0;
	 Human(){
		 humancount++;
	 }
	 void walking() {
		 System.out.println("Human is walking");
	 }
	 void talking() {
		 System.out.println("Human is talking");
	 }

}

class Boy extends Human{
	Boy(){
		super();
	}
	void walking() {
		System.out.println("boy is walking");
	}
	void talking() {
		System.out.println("Boy is talking");
	}
}

class Girl extends Human{
	Girl(){
		super();
	}
	
	void walking() {
		System.out.println("Girl is walking");
	}
	
	void talking() {
		System.out.println("Girl is talking");
	}

}

class Robot {
	static int robotcount=0;
	Robot(){
		robotcount++;
	}
	void walking() {
		System.out.println("Robot is walking");
	}
	void talking() {
		System.out.println("Robot is talking");
	}

}

public class Populationcount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boy b1=new Boy();
		Boy b2=new Boy();
		Boy b3=new Boy();
		
		Girl g1=new Girl();
		Girl g2=new Girl();
		Girl g3=new Girl();
		
		Robot r1=new Robot();
		Robot r2=new Robot();
		Robot r3=new Robot();
		
		System.out.println("Human population="+Human.humancount);
		System.out.println("Robot population="+Robot.robotcount);
	}

}
