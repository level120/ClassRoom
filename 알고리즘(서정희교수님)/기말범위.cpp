//########################## Chapter 4. Dynamic Programming ##########################

/*
	[분할정복]
		- 분할되는 소문제가 독립적이어서 소문제를 다시 나눌 수 있는 최대한으로 나누어 푼 결과를 합침.
		- TopDown(하향식 해결법)방식이며, 나누어진 부분 문제들은 서로 상관관계가 없을 때 적합.

	[동적계획법]
		- 분할정복과 같은 맥락으로 문제를 풀 때, 중복되는 부분이 발생할 경우에 적합.
		- 소문제에 대한 결과를 저장(Memorization), 같은 결과를 받는 경우 계산하지 않고 저장된 결과를 가져옴.
		- BottomUp(상향식 해결법)방식이며, 나누어진 부분 문제들이 서로 관련이 있을 때 적합.
*/

/*
	[이항계수]
		- input		: unsigned int n, k		( k <= n )
		- output	: bin, 이항계수[n,k]
		- time		: Θ(nk)
*/
//이항계수 알고리즘(recursive)
int bin( int n, int k )
{
	if ( k == 0 || n == k )
		return 1;
	else
		return bin( n-1, k-1 ) + bin( n-1, k );
}
//이항계수 알고리즘(DP)
int bin( int n, int k )
{
	int backup[ 0..n ][ 0..k ];
	for( int i = 0; i <= n; i++ )
	{
		for ( int j = 0; j <= min( i, k); j++ )
		{
			if ( j == 0 || j == i )
				backup[ i ][ j ] = 1;
			else
				backup[ i ][ j ] = backup[ i-1 ][ j-1 ] + backup[ i-1 ][ j ];
		}
	}
	return backup[ n ][ k ];
}


/*
	[최단거리 Floyd Algorithm]
		input	: Graph W including weight, Edge n
		output	: Graph D including shout distance
		hint	: k, i, j, i, k, k, j
*/
// Floyd Algorithm No.1
void floyd( int n, const int** W, int** D )
{
	D = W;

	for ( int k = 1; k <= n; k++ )
	{
		for ( int i = 1; i <= n; i++ )
		{
			for ( int j = 1; j <= n; j++ )
				D[ i ][ j ] = min( D[ i ][ j ], D[ i ][ k ] + D[ k ][ j ] );
		}
	}
}


/*
	[최적화 문제]
		- 최소 또는 최대치를 요하는 문제에 적용.
		- 작은 문제의 최적해부터 큰 문제의 최적해를 구하는 여러과정을 거침.
		- 최단경로가 최적화 문제에 속함.

	[최적성의 원리]
		- DP로 문제를 해결하려면 해당 문제가 최적성의 원리를 만족해야 함.
		- 어떠한 문제의 입력에 대한 최적해가 분할 된 문제에서도 최적해가 된다면,
		  "그 문제는 최적의 원칙이 적용된다"라고 한다.
		- 예를들어, 경성대에서 우리학교까지 가장 빨리오는 길에 부경대가 있으면,
		  경성대에서 부경대까지, 부경대에서 우리학교까지도 가장 빠른 길이 된다.

	[최적성의 원리 적용]
		- 어떠한 문제의 한 사례에 대한 최적해가 모든 부분사례에 대한 최적해들을 항상 포함할 때.
*/


//########################## Chapter 5. Back Tracking ##########################

/*
	[N-Queens 문제]
		- 상태공간트리 문제에서는 시작 S로부터 모든 조건이 만족할 때 까지 진행하면 된다.
*/
// N-Queens Algorithm
void queens( int i )
{
	if ( promising( i ) )
	{
		if ( i == N )
			print( Queens[ 1..N ] );
		else
		{
			for ( int j = 1; j <= N; j++ )
			{
				Queens[ i+1 ] = j;
				queens( i+1 );
			}
		}
	}
}

bool promising( int i )
{
	bool check = true;

	for( int k = 1; k < i && check; k++ )
	{
		if ( Queens[ i ] == Queens[ k ] || abs( Queens[ i ] - Queens[ k ] ) == i-k )
			check = false;
	}
	return check;
}

/*
	[부분 합 구하기 문제]
		input	: unsigned int n, sorted unsigned int w, unsigned int W
		output	: when all of sum is equal W, contain unsigned int set
*/
// Sum Algorithm
void sum( int i, int weight, int total )
{
	if ( promising( i ) )
	{
		if ( weight == W )
			print( incluide[ 1..i ] )
		else
		{
			include[ i+1 ] = "yes";
			sum( i+1, weight + w[ i+1 ], total - w[ i+1 ] );
			include[ i+1 ] = "no";
			sum( i+1, weight, total - w[ i+1 ] );
		}
	}
}

bool promising( int i )
{
	return ( weight + total >= W ) && ( weight == W || weight + w[ i+1 ] <= W );
}

/*
	[M-색칠하기 문제]
		input	: when a Edge exist Vertex i between Vertex j, W[i][j] = true, isn't W[i][j] = false
		output	: vcolor[1..n]
*/
// M-색칠하기 Algorithm
void m_coloring( int i )
{
	if ( promising( i ) )
	{
		if ( i == n )
			print( vcolor[1..n] );
		else
		{
			for( int color = 1; color <= m; color++ )
			{
				vcolor[ i+1 ] = color;
				m_coloring( i+1 );
			}
		}
	}
}

bool promising( int i )
{
	bool check = true;

	for( int k = 1; k <= i && check; k++ )
	{
		if ( W[ i ][ j ] && vcolor[ i ] == vcolor[ k ] )
			check = false;
	}
	return check;
}


//########################## Chapter 7. 계산복잡도의 소개 ##########################

/*
	[역 제거 하한선]
		- index i, j 가 있고 value[] k 가 있을 때, i < j && ki > kj 가 해당 됨.
		  예를들어, set[3, 2, 4, 1, 6, 5] 가 있다면 역은 5개 존재함.
		- 시간복잡도의 경우 최악 n(n-1)/2, 평균 n(n-1)/4
*/

/*
	[Heap Sort]
		- 완전 이진트리(Depth는 동일)
		- Heap property : 어떤 마디에 저장된 값은 자식 마디에 저장된 값보다 크거나 같다.
*/
//Heap Sort Algorithm
void shiftdown( head& H )
{
	node parent, largechild;
	parent		= root of H;
	largechild	= 큰 키를 가진 parent의 자식마디;

	while( parent key < largechild key )
	{
		swap( parent key, largechild key );
		parent = largechild;
		largechild = parent의 자식 중 큰 값을 가진 key;
	}
}

keytype root( heap& H )
{
	keytype keyout = root key;
	바닥의 키를 뿌리 마디로 옮김;
	바닥의 키를 지움;
	shiftdown( H );
	return keyout;
}

void removekeys( int n, heap H, keytype S[] )
{
	for ( int i = n; i >= 1; i-- )
		S[ i ] = root( H );
}

void makeheap( int n, heap& H )
{
	heap Hsub;
	for ( int i = d - 1; i >= 0; i-- )
	{
		for( 깊이가 i인 모든 부분 트리 Hsub )
			shiftdown( Hsub );
	}
}

void heapsort( int n, heap H, keytype S[] )
{
	makeheap( n, H );
	removekeys( n, H, S );
}