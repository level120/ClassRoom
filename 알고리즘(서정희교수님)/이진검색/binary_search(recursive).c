#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <algorithm>
 
#define MAX_SIZE 10
 
int S[ MAX_SIZE ];        // 전역 배열
 
int binsearch( int low, int high, int x);
void init();
 
int main()
{
    int input;
 
    init();
    scanf( "%d", &input );
 
    printf( "result : %d\n", binsearch( 0, MAX_SIZE - 1, input ) + 1 );        // 여기서 + 1
    return 0;
}
 
// location >= 0 : 위치를 찾음,        location < 0 : 위치 못찾음
int binsearch( int low, int high, int x )
{
    int mid;
 
    if ( low > high )
        return -1;
    else
    {
        mid = ( low + high ) / 2;
 
        if ( x == S[ mid ] )
            return mid;
        else if ( x < S[ mid ] )
            return binsearch( low, mid - 1, x );
        else
            return binsearch( mid + 1, high, x );
    }
}
 
void init()
{
    int i;
    srand( time( NULL ) );
 
    for ( i = 0; i < MAX_SIZE; i++ )
        S[ i ] = rand() % 100 + 1;
 
    std::sort( S, S + MAX_SIZE );
 
    for ( int i = 0; i < MAX_SIZE; i++ )
        printf( "%d ", S[ i ] );
    puts( "" );
}