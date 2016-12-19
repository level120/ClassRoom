class TestCar {
	public static void main(String[] args){
		Car Sonata=new Car("Sonata","blue");
		Car Matiz=new Car("Martiz","red");
		Car Beetle=new Car("Beetle","green",0);
		Car SM6=new Car("SM6","black",0);
		
		System.out.println(Sonata.toString());
		System.out.println(Matiz.toString());
		System.out.println(Beetle.toString());
		System.out.println(SM6.toString());
		System.out.println();
		
		for(int i=0; i<27; i++)
			Sonata.speedUp();
		for(int i=0; i<15; i++)
			SM6.turbo();
		for(int i=0; i<24; i++)
			Beetle.speedUp();
		for(int i=0; i<27; i++)
			Matiz.speedUp();
		
		System.out.println(Sonata.toString());
		System.out.println(Matiz.toString());
		System.out.println(Beetle.toString());
		System.out.println(SM6.toString());
		System.out.println();
		
		for(int i=0; i<17; i++)
			Sonata.speedDown();
		for(int i=0; i<50; i++)
			SM6.speedDown();
		for(int i=0; i<5; i++)
			Beetle.turbo();
		for(int i=0; i<27; i++)
			Matiz.speedDown();
		
		System.out.println(Sonata.toString());
		System.out.println(Matiz.toString());
		System.out.println(Beetle.toString());
		System.out.println(SM6.toString());
		System.out.println();
	}
}