#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX_SIZE 15
 
int array[ MAX_SIZE ];
 
void init();
void print();
void swap( int* x, int * y );
void quicksort( int low, int high );
void partition( int low, int high, int* pivotpoint );
 
 
int main()
{
    init();
    print();
    quicksort( 0, MAX_SIZE-1 );
    puts( "" );
    print();
    return 0;
}
 
void init()
{
    srand( time(NULL) );
    for ( int i=0; i<MAX_SIZE; i++ )
        array[ i ] = rand() % 100 + 1;
}
 
void print()
{
    int i;
    for ( i = 0; i < MAX_SIZE; i++ )
        printf( "%d ", array[ i ] );
}
 
void swap( int* x, int *y )
{
    int tmp = *x;
    *x = *y;
    *y = tmp;
}
 
void quicksort( int low, int high )
{
    int pivotpoint;
 
    if ( high > low ) {
        partition( low, high, &pivotpoint );
        quicksort( low, pivotpoint-1 );
        quicksort( pivotpoint+1, high );
    }
}
 
void partition( int low, int high, int* pivotpoint)
{
    int pivotitem = array[ low ];
    int j = low;
    for ( int i=low+1; i<=high; i++ )
    {
        if ( array[ i ] < pivotitem )
            swap( &array[ i ], &array [ ++j ] );
    }
    *pivotpoint = j;
    swap( &array[ low ], &array[ *pivotpoint ] );
}