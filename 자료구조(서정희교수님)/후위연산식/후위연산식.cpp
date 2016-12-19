#include <cstdio>
#include <stack>
#include <iostream>
using namespace std;

char c[10000000];
int main() {
	stack<char> k;	// 괄호
	stack<char> m;	// 연산자
	scanf("%s", c);
	for (int i = 0; c[i] != 0; i++) {
		if (c[i] == '(')	k.push(c[i]);
		else if ((c[i] == ')'&&!k.empty())) {
			printf("%c", m.top());
			m.pop();
			k.pop();
			if (k.empty() && !m.empty()) {
				while (!m.empty()) {
					printf("%c", m.top());
					m.pop();
				}
			}
		}
		else if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/')	m.push(c[i]);
		else {
			if (c[i] > 64 && c[i] < 82) {
				printf("%c", c[i]);
				if (k.empty()&&!m.empty()&&c[i+1]!='*'&&c[i+1]!='/') {
					while (!m.empty()) {
						printf("%c", m.top());
						m.pop();
					}
				}
			}
		}
	}
	return 0;
}