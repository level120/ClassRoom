#include <stdio.h>
#define MAX_SIZE 10
 
int fib( int n )
{
    return n < 2 ? n : ( fib( n - 1 ) + fib( n - 2 ) );
}
 
int main()
{
    printf( "n��° �Ǻ���ġ �� : %d\n", fib( MAX_SIZE ) );
    return 0;
}