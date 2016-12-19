class CarTest {
	public static void main(String[] args){
		Car c4=new Car("BMW i8","brown");
		Car c5=new Car("Morning","white");
		Car c6=new Car("QM5","blue");
		
		c4.setNumber("55오5500");
		for(int i=0; i<200; i++)
			c4.speedUp();
		c4.setColor("white");
		for(int i=0; i<120; i++)
			c4.speedDown();
		
		c5.setNumber("12저3298");
		for(int i=0; i<80; i++)
			c5.speedUp();
		c5.setNumber("37주2200");
		for(int i=0; i<25; i++)
			c5.speedDown();
		
		c6.setNumber("57수6095");
		for(int i=0; i<120; i++)
			c6.speedUp();
		for(int i=0; i<90; i++)
			c6.speedDown();
		
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
	}
}