class Car {
	private String name, color, number;
	private int speed, gear;
	
	// ### »ý¼ºÀÚ ###
	Car(String name){
		this(name,"white");
	}
	Car(String name, String color){
		this.name=name;
		this.color=color;
	}
	
	// ### Color ###
	void setColor(String color){
		this.color=color;
	}
	String getColor(){
		return this.color;
	}
	
	// ### Number ###
	void setNumber(String number){
		this.number=number;
	}
	String getNumber(){
		return this.number;
	}
	
	// ### Speed ###
	void speedUp(){
		if(++this.speed>180)	this.speed=180;
	}
	void speedDown(){
		if(--this.speed<0)	this.speed=0;
	}
	
	@Override
	public String toString(){
		return String.format("[%s,%s,%s,%d]", name, color, number, speed);
	}
}