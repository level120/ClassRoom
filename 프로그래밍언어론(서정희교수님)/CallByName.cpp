/*
 *	Call by Name Example
 */

// Algol60

begin
	integer A[4], i;
	procedure swap( x, y ); integer x, y;
		begin
			integer temp;
			temp := x;
			x := y;
			y := temp;
		end
	...
	i := 2;
	A[2] := 3;
	A[3] := 4;

	swap( i, A[i] );
	print( i, A[i] );
end


----------------------------------

// C++
// 위의 코드를 나타내면 다음과 같으나, 동작하는 원리가 전혀 다르기에 아래 코드를 보는 것을 비추함.

void swap( int& x, int & y )
{
	int temp;
	temp = x;
	x = y;
	y = temp;
}

int main( void )
{
	int i;
	int A[4];

	i = 2;
	A[2] = 3;
	A[3] = 4;

	swap( i, A[2] );
	cout << "value i : " << x << "\tvalue A[i] : " << A[i] << endl;
	return 0;
}