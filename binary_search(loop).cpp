#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <algorithm>
 
#define MAX_SIZE 10
 
void binsearch( int n, const int *S, int x, int* location );
void init(int n, int* S);
 
int main()
{
    int input, s[ MAX_SIZE ], result;
 
    init( MAX_SIZE, s );
    scanf( "%d", &input );
    binsearch( MAX_SIZE - 1, s, input, &result );
 
    printf( "result : %d\n", result + 1 );        // 여기서 + 1
    return 0;
}
 
// location >= 0 : 위치를 찾음,        location < 0 : 위치 못찾음
void binsearch( int n, const int *S, int x, int* location )
{
    int low = 0, high = n, mid;
    *location = -1;
 
    while ( low <= high && *location == -1 )
    {
        mid = ( low + high ) / 2;
        if ( x == S[ mid ] )
            *location = mid;
        else if ( x < S[ mid ] )
            high = mid - 1;
        else
            low = mid + 1;
    }
}
 
void init( int n, int* S )
{
    int i;
    srand( time( NULL ) );
 
    for ( i = 0; i < n; i++ )
        S[ i ] = rand() % 100 + 1;
 
    std::sort( S, S + n );
 
    for ( int i = 0; i < n; i++ )
        printf( "%d ", S[ i ] );
    puts( "" );
}