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
// ���� �ڵ带 ��Ÿ���� ������ ������, �����ϴ� ������ ���� �ٸ��⿡ �Ʒ� �ڵ带 ���� ���� ������.

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