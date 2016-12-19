import java.util.Arrays;

class Card {
	private int[][] card=new int[4][13];		// �� 52���� ī�尡 ��� �迭
	private int[] countResult=new int[8];		// �� ����� �� ȸ ������ ����� �迭
	private int uwin, cwin, draw;				// ���� �����¸�, ��ǻ�� �¸�, ���º�
	private String winner, loser;				// �� ȸ ���� �� ���ڸ� ����� ����

	Card(int n){
		classSetting();							// �ʵ��� �ʱⰪ ����
		for(int i=0; i<n; i++){
			setting();							// �� �� ī�带 �ʱ�ȭ
			game();								// 1�� ����
			printResult(i);						// ���� ��� ���
		}
		printResult2();							// ���� ��� ���
	}

	/*	public static void main(String[] args){
		new Card(10);
	}*/

	void classSetting(){	// �ʵ� �ʱⰪ ����
		this.uwin=0;
		this.cwin=0;
		this.draw=0;
	}

	void setting(){			// �� �� ī�带 �ʱ�ȭ
		for(int i=0; i<4; i++){
			for(int j=0; j<13; j++)
				card[i][j]=1;
		}
	}

	void game(){			// ���� ����
		//java.util.Random r=new java.util.Random();
		int[][] computer=new int[4][7];		// ��ǻ���� ī��
		int[][] user=new int[4][7];			// ������ ī��

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

		for(int i=0; i<4; i++){			// �� �޼ҵ忡 �ֱ��� ��� �ִ� ī�� ����
			Arrays.sort(computer[i]);
			Arrays.sort(user[i]);
		}

		int resultUser=-1, resultComputer=-1;	// -1 ���� �ش� �޼ҵ��� ����� �ƴ��� �ǹ�

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

	int straightFlush(int[][] users){	// ��Ʈ����Ʈ �÷��� �Ǻ�
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

	int porker(int[][] users){			// ��Ŀ �Ǻ�
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

	int fullHouse(int[][] users){		// Ǯ�Ͽ콺 �Ǻ�
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

	int flush(int[][] users){			// �÷��� �Ǻ�
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

	int straight(int[][] users){		// ��Ʈ����Ʈ �Ǻ�
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

	int triple(int[][] users){			// Ʈ���� �Ǻ�
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

	int twoPair(int[][] users){			// ����� �Ǻ�
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

	int onePair(int[][] users){			// ����� �Ǻ�
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

	int finalMathch(int[][] users, int[][] computers){					// ����� ���� �ʾ��� �� ���� ��
		int userCard=13, computerCard=13;
		for(int i=0; i<4; i++){
			if(users[i][0]<userCard)			userCard=users[i][0];
			if(computers[i][0]<computerCard)	computerCard=users[i][0];
		}
		return userCard>computerCard?1:userCard<computerCard?(-1):0;	// 1 ��ǻ�� �¸�, -1 ���� �¸�, 0 ���º�
	}

	void printResult(int n){
		System.out.printf("%4d��° ���Ӱ�� - �¸� : %-10s, �й� : %-10s\t�·� - ���� : %.2f%% , ��ǻ�� : %.2f%% , ���º� : %.2f%%\n", (n+1),winner,loser,(double)uwin/(n+1)*100,(double)cwin/(n+1)*100,(double)draw/(n+1)*100);
	}

	void printResult2(){
		String[] menu={"StraightFlush","Porker","FullHouse","Flush","Straight","Triple","TwoPair","OnePair"};
		System.out.println("-----------------------���� ����--------------------------");
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