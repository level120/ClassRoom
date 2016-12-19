// https://www.acmicpc.net/problem/1918 통과코드

#include <iostream>
#include <stack>
#include <string>
using namespace std;

int check_op(char op);
int check(char op1, char op2);

int main() {
	string s, ans="";
	stack<char> op;
	cin >> s;
	int idx = 0, len = s.length();
	for (int i = 0; i < len; i++) {
		if (s[i] > 64 && s[i] < 92)
            ans += s[i];
		else {
			switch (s[i]) {
			case '(':
				op.push(s[i]);
				break;
			case ')':
				while (op.top() != '(') {
					ans += op.top();
					op.pop();
				}
				op.pop();
				break;
			case '+':	case '-':	case '*':	case '/':
				while (!op.empty() && check(op.top(), s[i]) >= 0) {
					ans += op.top();
					op.pop();
				}
				op.push(s[i]);
				break;
			}
		}
	}
	while (!op.empty()) {
		ans += op.top();
		op.pop();
	}
	cout << ans;
	return 0;
}

int check_op(char op) {
	switch (op) {
	case '*':	case '/':
		return 1;
	case '+':	case '-':
		return 0;
	}
	return -1;
}

int check(char op1, char op2) {
	return check_op(op1) > check_op(op2) ? 1 : check_op(op1) < check_op(op2) ? -1 : 0;
}