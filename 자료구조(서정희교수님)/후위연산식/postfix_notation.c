/*
	* 후위표기식 과제

	* 최종수정 : 16.05.14. 00:34
	* 관련문제 : acmicpc.net/problem/1918
	* 관련문제 : acmicpc.net/problem/1935

	* 보다 정확한 계산을 위해 모두 실수형으로 계산
	* 입력되는 숫자는 반드시 0~9 이다.
	  (단, 0으로 나누는 것은 안된다.)
		
		<!-- 적용함수 -->
		- push_double()	stack에 double형 데이터 삽입 함수
		- push_char()	stack에 char형 데이터 삽입 함수
		- pop()			stack에 맨 마지막 데이터를 삭제
		- empty()		stack이 비었는지 확인
		- res()			주어진 식 계산하여 결과값을 return
		- check_op()	연산자 우선순위를 확인
		- check()		두 연산자의 우선순위를 확인

		<!-- 전역변수 -->
		- buffer		입력되는 문자를 임시로 저장
		- ans			정답을 저장할 배열
		- top_res		res() 함수에서 답을 계산하기 위한 리스트형 스택

		<!-- 지역변수 -->
		- top_op		연산자를 확인하기 위한 리스트형 스택
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_SIZE 1000000

typedef struct Stack {
	char data;
	double ans;
	struct Stack * link;
}stack;

void push_double(stack **top, double data);
void push_char(stack **top, char data);
void pop(stack **top);
int empty(stack **top);
int check_op(char op);
int check(char op1, char op2);
double res();

char buffer[MAX_SIZE];
char ans[MAX_SIZE];

int main() {
	int i, idx = 0, len = 0;
	stack *top_op = NULL;
	scanf("%s", buffer);
	len = strlen(buffer);
	for (i=0; i<len; i++) {
		if (buffer[i] > 47 && buffer[i] < 58)
			ans[idx++] = buffer[i];
		else {
			switch (buffer[i]) {
			case '(':
				push_char(&top_op, buffer[i]);
				break;
			case ')':
				while (top_op->data != '(') {
					ans[idx++] = top_op->data;
					pop(&top_op);
				}
				pop(&top_op);
				break;
			case '+':	case '-':	case '*':	case '/':
				while (!empty(&top_op) && check(top_op->data, buffer[i]) >= 0) {
					ans[idx++] = top_op->data;
					pop(&top_op);
				}
				push_char(&top_op, buffer[i]);
				break;
			}
		}
	}
	while (!empty(&top_op)) {
		ans[idx++] = top_op->data;
		pop(&top_op);
	}
	printf("Convert : ");
	puts(ans);
	printf("Value : %.2lf\n", res());
	return 0;
}

double res() {
	stack *top_res = NULL;
	int i, len = strlen(ans);
	double tmp1, tmp2;
	for(i=0; i<len; i++) {
		if (ans[i] > 47 && ans[i] < 58)
			push_double(&top_res, ans[i] - 48);
		else {
			tmp1 = 0.0;
			tmp2 = top_res->ans;
			pop(&top_res);

			switch (ans[i]) {
			case '*':
				tmp1 = top_res->ans * tmp2;
				pop(&top_res);
				push_double(&top_res, tmp1);
				break;
			case '/':
				tmp1 = top_res->ans / tmp2;
				pop(&top_res);
				push_double(&top_res, tmp1);
				break;
			case '+':
				tmp1 = top_res->ans + tmp2;
				pop(&top_res);
				push_double(&top_res, tmp1);
				break;
			case '-':
				tmp1 = top_res->ans - tmp2;
				pop(&top_res);
				push_double(&top_res, tmp1);
				break;
			}
		}
	}
	return top_res->ans;
}

void push_double(stack **top, double data) {
	stack * new_stack = (stack *)malloc(sizeof(stack));
	new_stack->ans = data;
	new_stack->link = *top;
	*top = new_stack;
}

void push_char(stack **top, char data) {
	stack * new_stack = (stack *)malloc(sizeof(stack));
	new_stack->data = data;
	new_stack->link = *top;
	*top = new_stack;
}

void pop(stack **top) {
	if (*top == NULL)	return;
	stack * tmp = *top;
	*top = (*top)->link;
	free(tmp);
}

int empty(stack **top) {
	return *top != NULL ? 0 : 1;
}

int check_op(char op) {
	switch(op) {
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