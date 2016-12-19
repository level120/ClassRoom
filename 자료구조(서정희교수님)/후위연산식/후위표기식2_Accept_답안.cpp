// https://www.acmicpc.net/problem/1935 통과코드

#include <iostream>
#include <stack>
#include <string>
using namespace std;

int val[26];

int main() {
	string s;
	stack<double> op;
	int t;
	scanf("%d", &t);
	cin >> s;
	for (int i = 0; i < t; i++) {
		int tmp;
		scanf("%d", &tmp);
		val[i] = tmp;
	}
	int idx = 0, len = s.length();
	for (int i = 0; i < len; i++) {
		if (s[i] > 64 && s[i] < 92)
			op.push((double)val[s[i]-65]);
		else {
			double ans = 0.0;
			double tmp = op.top();
			op.pop();

			switch (s[i]) {
			case '*':
				ans = op.top()*tmp;
				op.pop();
				op.push(ans);
				break;
			case '/':
				ans = op.top()/tmp;
				op.pop();
				op.push(ans);
				break;
			case '+':
				ans = op.top()+tmp;
				op.pop();
				op.push(ans);
				break;
			case '-':
				ans = op.top()-tmp;
				op.pop();
				op.push(ans);
				break;
			}
		}
	}
	printf("%.2lf", op.top());
	return 0;
}