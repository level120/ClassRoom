#include <bits/stdc++.h>
#define INF 10000001

void floyd( int n, int W[][5], int D[][5], int P[][5] );
void path( int q, int r, int P[][5] );
void print( int arr[][5], int n, int p[][5] );

int main( int argc, char* argv[] )
{
	const int N = 5;
	int d[N][N];
	int p[N][N];
	int w[N][N] = 
	{
		{ 0, 1, INF, 1, 5 },
		{ 9, 0, 3, 2, INF },
		{ INF, INF, 0, 4, INF },
		{ INF, INF, 2, 0, 3 },
		{ 3, INF, INF, INF, 0 }
	};

	puts( "Using Graph, ppt. p.26\n" );
	floyd( N, w, d, p );

	for ( int i = 0; i < N; i++ )
	{
		for ( int j = 0; j < N; j++ )
		{
			printf( "Begin(%d,%d) : V%d ", i + 1, j + 1, i + 1 );
			path( i, j, p );
			printf( ( d[i][j] != 0 ) ? ( "-> V%d\n") : "\n", j + 1 );
		}
		puts( "" );
	}

	return 0;
}

void floyd( int n, int W[][5], int D[][5], int P[][5] )
{
	for ( int i = 0; i < n; i++ )
	{
		for ( int j = 0; j < n; j++ )
		{
			P[i][j] = 0;
			D[i][j] = W[i][j];
		}
	}

	for ( int k = 0; k < n; k++ )
	{
		for ( int i = 0; i < n; i++ )
		{
			for ( int j = 0; j < n; j++ )
			{
				if ( D[i][k] + D[k][j] < D[i][j] )
				{
					P[i][j] = k + 1;
					D[i][j] = D[i][k] + D[k][j];
				}
			}
		}
		print( D, k, P );
	}
}

void print( int arr[][5], int n, int p[][5] )
{
	printf( "D[%d]\t\t\t\tP[%d]\n", n+1, n+1 );

	for ( int i = 0; i < 5; i++ )
	{
		printf( "[ " );

		for ( int j = 0; j < 5; j++ )
		{
			printf( ( arr[i][j] != INF ) ? ( "%3d " ) : ( "INF " ), arr[i][j] );
		}

		printf( "]\t\t[" );

		for ( int j = 0; j < 5; j++ )
		{
			printf( "%3d ", p[i][j] );
		}

		printf( "]\n" );
	}
	puts( "" );
}

void path( int q, int r, int P[][5] )
{
	if ( P[q][r] != 0 )
	{
		path( q, P[q][r] - 1, P );
		printf( "-> v%d ", P[q][r] );
		path( P[q][r] - 1, r, P );
	}
}
