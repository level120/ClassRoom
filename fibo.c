#include <stdio.h>
#define MAX_SIZE 10
 
int fib( int n )
{
    return n < 2 ? n : ( fib( n - 1 ) + fib( n - 2 ) );
}
 
int main()
{
    printf( "n번째 피보나치 수 : %d\n", fib( MAX_SIZE ) );
    return 0;
}