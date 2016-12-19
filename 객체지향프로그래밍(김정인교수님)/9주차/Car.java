class Car {
	private String model, color;
	private int speed, id;
	static private int pid=0;
	
	Car(String model, String color, int speed){
		this.id=++Car.pid;
		setModel(model);
		setColor(color);
		setSpeed(speed);
	}
	Car(String model, String color){
		this(model, color, 0);
	}
	
	void setModel(String model){
		this.model=model;
	}
	void setColor(String color){
		this.color=color;
	}
	void setSpeed(int speed){
		this.speed=speed;
	}
	
	void speedUp(){
		if(this.speed<248)	this.speed+=3;
		else System.out.println("Lock!");
	}
	void speedDown(){
		if(this.speed>2)	this.speed-=3;
		else System.out.println("Lock!");
		if(this.speed==0)
			System.out.println(this.model+"의 차량이 정지하였습니다.");
	}
	void turbo(){
		if(this.speed<241)	this.speed+=10;
		else System.out.println("Lock!");
	}
	
	public String toString(){
		return String.format("ID : %04d\t차량모델 : %s\t차량색상 : %s\t현재속도 : %d", id,model,color,speed);
	}
}