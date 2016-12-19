import java.util.Arrays;

class Card {
	private int[][] card=new int[4][13];		// 총 52장의 카드가 담길 배열
	private int[] countResult=new int[8];		// 각 결과가 몇 회 떳는지 기록할 배열
	private int uwin, cwin, draw;				// 각각 유저승리, 컴퓨터 승리, 무승부
	private String winner, loser;				// 매 회 승자 및 패자를 기록할 변수

	Card(int n){
		classSetting();							// 필드의 초기값 설정
		for(int i=0; i<n; i++){
			setting();							// 매 판 카드를 초기화
			game();								// 1판 진행
			printResult(i);						// 게임 결과 출력
		}
		printResult2();							// 종합 결과 출력
	}

	/*	public static void main(String[] args){
		new Card(10);
	}*/

	void classSetting(){	// 필드 초기값 설정
		this.uwin=0;
		this.cwin=0;
		this.draw=0;
	}

	void setting(){			// 매 판 카드를 초기화
		for(int i=0; i<4; i++){
			for(int j=0; j<13; j++)
				card[i][j]=1;
		}
	}

	void game(){			// 게임 진행
		//java.util.Random r=new java.util.Random();
		int[][] computer=new int[4][7];		// 컴퓨터의 카드
		int[][] user=new int[4][7];			// 유저의 카드

		for(int i=0; i<4; i++){				// default set, computer and user
			Arrays.fill(computer[i],99);
			Arrays.fill(user[i],99);
		}

		for(int i=0; i<7; i++){			// user card setting
			//			int x=r.nextInt(4);
			//			int y=r.nextInt(13);
			int x=(int)(Math.random()*10)%4;
			int y=(int)(Math.random()*100)%13;
			while(card[x][y]==0){
				//				x=r.nextInt(4);
				//				y=r.nextInt(13);
				x=(int)(Math.random()*10)%4;
				y=(int)(Math.random()*100)%13;
			}
			user[x][i]=y;
			card[x][y]=0;
		}
		for(int i=0; i<7; i++){			// computer card setting
			//			int x=r.nextInt(4);
			//			int y=r.nextInt(13);
			int x=(int)(Math.random()*10)%4;
			int y=(int)(Math.random()*100)%13;
			while(card[x][y]==0){
				//				x=r.nextInt(4);
				//				y=r.nextInt(13);
				x=(int)(Math.random()*10)%4;
				y=(int)(Math.random()*100)%13;
			}
			computer[x][i]=y;
			card[x][y]=0;
		}

		for(int i=0; i<4; i++){			// 각 메소드에 넣기전 들고 있는 카드 정렬
			Arrays.sort(computer[i]);
			Arrays.sort(user[i]);
		}

		int resultUser=-1, resultComputer=-1;	// -1 값은 해당 메소드의 결과가 아님의 의미

		if(resultUser==-1)	resultUser=straightFlush(user);
		if(resultUser==-1)	resultUser=porker(user);
		if(resultUser==-1)	resultUser=fullHouse(user);
		if(resultUser==-1)	resultUser=flush(user);
		if(resultUser==-1)	resultUser=straight(user);
		if(resultUser==-1)	resultUser=triple(user);
		if(resultUser==-1)	resultUser=twoPair(user);
		if(resultUser==-1)	resultUser=onePair(user);

		if(resultComputer==-1)	resultComputer=straightFlush(computer);
		if(resultComputer==-1)	resultComputer=porker(computer);
		if(resultComputer==-1)	resultComputer=fullHouse(computer);
		if(resultComputer==-1)	resultComputer=flush(computer);
		if(resultComputer==-1)	resultComputer=straight(computer);
		if(resultComputer==-1)	resultComputer=triple(computer);
		if(resultComputer==-1)	resultComputer=twoPair(computer);
		if(resultComputer==-1)	resultComputer=onePair(computer);

		if(resultUser==resultComputer){
			int tmp=finalMathch(user, computer);
			if(tmp>0)		{this.cwin++; this.winner="Computer"; this.loser="User";}
			else if(tmp<0)	{this.uwin++; this.winner="User"; this.loser="Computer";}
			else			{this.draw++; this.winner="Draw"; this.loser="Draw";}
		}
		else{
			if(resultUser>resultComputer)		{this.cwin++; this.winner="Computer"; this.loser="User";}
			else if(resultUser<resultComputer)	{this.uwin++; this.winner="User"; this.loser="Computer";}
			else								{this.draw++; this.winner="Draw"; this.loser="Draw";}
		}
	}

	int straightFlush(int[][] users){	// 스트레이트 플러쉬 판별
		for(int i=0; i<4; i++){
			boolean check=false;
			if(users[i][0]!=99&&users[i][1]==users[i][0]+1&&users[i][2]==users[i][1]+1&&users[i][3]==users[i][2]+1&&users[i][4]==users[i][3]+1){
				check=true;
			}
			if(users[i][1]!=99&&users[i][2]==users[i][1]+1&&users[i][3]==users[i][1]+1&&users[i][4]==users[i][2]+1&&users[i][5]==users[i][3]+1){
				check=true;
			}
			if(users[i][2]!=99&&users[i][3]==users[i][2]+1&&users[i][4]==users[i][3]+1&&users[i][5]==users[i][4]+1&&users[i][6]==users[i][5]+1){
				check=true;
			}
			if(check)	{
				this.countResult[0]++;
				return 9;
			}
		}
		return -1;
	}

	int porker(int[][] users){			// 포커 판별
		int[] tmp=new int[13];
		for(int i=0; i<4; i++){
			for(int j=0; j<7; j++){
				if(users[i][j]!=99)
					tmp[users[i][j]]++;
			}
		}
		for(int i=0; i<tmp.length; i++){
			if(tmp[i]>3) {
				this.countResult[1]++;
				return 8;
			}
		}
		return -1;
	}

	int fullHouse(int[][] users){		// 풀하우스 판별
		int[] tmp=new int[13];
		for(int i=0; i<4; i++){
			for(int j=0; j<7; j++){
				if(users[i][j]!=99)
					tmp[users[i][j]]++;
			}
		}
		Arrays.sort(tmp);
		for(int i=0; i<tmp.length-1; i++){
			if(tmp[i]>1&&tmp[i+1]>2){
				this.countResult[2]++;
				return 7;
			}
		}
		return -1;
	}

	int flush(int[][] users){			// 플러쉬 판별
		for(int i=0; i<4; i++){
			int count=0;
			for(int j=0; j<7; j++){
				if(users[i][j]==99)	count++;
			}
			if(count<3){
				this.countResult[3]++;
				return 6;
			}
		}
		return -1;
	}

	int straight(int[][] users){		// 스트레이트 판별
		int[] tmp=new int[13];
		for(int i=0; i<4; i++){
			for(int j=0; j<7; j++){
				if(users[i][j]!=99)
					tmp[users[i][j]]++;
			}
		}
		for(int i=0; i<9; i++){
			if(tmp[i]!=0&&tmp[i+1]!=0&&tmp[i+2]!=0&&tmp[i+3]!=0&&tmp[i+4]!=0){
				this.countResult[4]++;
				return 5;
			}
		}
		return -1;
	}

	int triple(int[][] users){			// 트리플 판별
		int[] tmp=new int[13];
		for(int i=0; i<4; i++){
			for(int j=0; j<7; j++){
				if(users[i][j]!=99)
					tmp[users[i][j]]++;
			}
		}
		Arrays.sort(tmp);
		for(int i=0; i<tmp.length; i++){
			if(tmp[i]>2){
				this.countResult[5]++;
				return 4;
			}
		}
		return -1;
	}

	int twoPair(int[][] users){			// 투페어 판별
		int[] tmp=new int[13];
		for(int i=0; i<4; i++){
			for(int j=0; j<7; j++){
				if(users[i][j]!=99)
					tmp[users[i][j]]++;
			}
		}
		boolean check=false;
		for(int i=0; i<tmp.length; i++){
			if(tmp[i]>1&&check)	{
				this.countResult[6]++;
				return 3;
			}
			if(tmp[i]>1)	check=true;
		}
		return -1;
	}

	int onePair(int[][] users){			// 원페어 판별
		int[] tmp=new int[13];
		for(int i=0; i<4; i++){
			for(int j=0; j<7; j++){
				if(users[i][j]!=99)
					tmp[users[i][j]]++;
			}
		}
		Arrays.sort(tmp);
		for(int i=0; i<tmp.length; i++){
			if(tmp[i]>1){
				this.countResult[7]++;
				return 2;
			}
		}
		return -1;
	}

	int finalMathch(int[][] users, int[][] computers){					// 결과가 나지 않았을 때 최종 비교
		int userCard=13, computerCard=13;
		for(int i=0; i<4; i++){
			if(users[i][0]<userCard)			userCard=users[i][0];
			if(computers[i][0]<computerCard)	computerCard=users[i][0];
		}
		return userCard>computerCard?1:userCard<computerCard?(-1):0;	// 1 컴퓨터 승리, -1 유저 승리, 0 무승부
	}

	void printResult(int n){
		System.out.printf("%4d번째 게임결과 - 승리 : %-10s, 패배 : %-10s\t승률 - 유저 : %.2f%% , 컴퓨터 : %.2f%% , 무승부 : %.2f%%\n", (n+1),winner,loser,(double)uwin/(n+1)*100,(double)cwin/(n+1)*100,(double)draw/(n+1)*100);
	}

	void printResult2(){
		String[] menu={"StraightFlush","Porker","FullHouse","Flush","Straight","Triple","TwoPair","OnePair"};
		System.out.println("-----------------------게임 종료--------------------------");
		for(int i=0; i<menu.length; i++){
			System.out.printf("%-14s ", menu[i]);
		}
		System.out.println();
		for(int i=0; i<countResult.length; i++){
			System.out.printf("%-14d ", countResult[i]);
		}
		System.out.println();
	}
}