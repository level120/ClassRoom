class HighLow {
	java.util.Scanner s=new java.util.Scanner(System.in);  // exception 방지
	private int guessNumber, hiddenNumber;
	private int high, low;
	private int tryCount;
	private boolean isWon;
	
	public HighLow(){
		setHiddenNumber();
		startGame();
		while(tryCount!=0 && !isWon){	// 승패조건
			inputNumber();
			checkNumber();
		}
		s.close();			// 여기서 scanner 종료
		printGame();
	}
	
	void setHiddenNumber(){
		java.util.Random r=new java.util.Random();
		hiddenNumber=r.nextInt(101);
	}
	
	void inputNumber(){
		System.out.printf("%d[%d]-[%d]:",7-tryCount,low,high);
		guessNumber=s.nextInt();
	}
	
	void checkNumber(){
		if(guessNumber<0 || guessNumber>100){		// 순서주의! 반드시 최우선으로 확인할 것.
			System.out.println("Out of range. Please input again.");
			return;
		}
		if(guessNumber==hiddenNumber)	{
			this.isWon=true;
			System.out.println("Bingo !");
			return;
		}
		else if(guessNumber>hiddenNumber){
			this.high=guessNumber-1;
			System.out.println("Too large number.");
		}
		else{
			this.low=guessNumber+1;
			System.out.println("Too small number.");
		}
		this.tryCount--;			// 순서 원인 제공
		return;
	}
	
	void printGame(){
		System.out.println(this.isWon?"You won":"You lost!\nHidden number is "+hiddenNumber);
	}
	
	void startGame(){
		this.high=100;
		this.low=0;
		this.tryCount=6;
		this.isWon=false;
	}
}