#include <stdio.h>
#include <stdlib.h>
#include <time.h>
 
#define MAX_SIZE 8
#define MAX_NUMBER 100

//주석 풀면 연산 과정 보여줌

void mergesort( int n, int* S );
void merge( int h, int m, const int* U, const int* V, int* S );
void copy( int* _origin, int* _new, int o_start, int n_start, int end );
void init( int n, int* S );
void print( int n, const int* S );
 
int main()
{
    int s[ MAX_SIZE ];
    init( MAX_SIZE, s);
    print( MAX_SIZE, s );
    mergesort( MAX_SIZE, s );
    print( MAX_SIZE, s );
    return 0;
}
 
void mergesort( int n, int* S )
{
    if ( n > 1 )
    {
        const int h = n / 2, m = n - h;
        int* U = ( int* )calloc( h, sizeof( int ) );
        int* V = ( int* )calloc( m, sizeof( int ) );
 
        copy( S, U, 0, 0, h );		// 원본배열, 복사받을 배열, 원본 시작 index, 사본배열 시작 index, 복사할 개수
	//print( h, U );
        copy( S, V, h, 0, n );		// 원본배열, 복사받을 배열, 원본 시작 index, 사본배열 시작 index, 복사할 개수
	//print( n, V );
 
        mergesort( h, U );
        mergesort( m, V );
 
        merge( h, m, U, V, S );
 
        free( U );
        free( V );
    }
}
 
void merge( int h, int m, const int* U, const int* V, int* S )
{
    int i = 0, j = 0, k = 0;
 
    while ( i < h && j < m )
    {
        if ( U[ i ] < V[ j ] )
            S[ k++ ] = U[ i++ ];
        else
            S[ k++ ] = V[ j++ ];
    }
 
    if ( i >= h )
        copy( V, S, j, k, m );
    else
        copy( U, S, i, k, h );
    //print( MAX_SIZE, S );
}
 
void copy( int* _origin, int* _new, int o_start, int n_start, int end )
{
    int i;
    for ( i = o_start; i < end; i++ )
    {
        _new[ n_start++ ] = _origin[ o_start++ ];
    }
}
 
void init( int n, int* S )
{
    int i;
    srand( time( NULL ) );
 
    for ( i = 0; i < n; i++ )
        S[ i ] = rand() % MAX_NUMBER + 1;
}
 
void print( int n, const int* S )
{
    for ( int i = 0; i < n; i++ )
        printf( "%d ", S[ i ] );
    puts( "" );
}
