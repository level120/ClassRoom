#include <stdio.h>

char target[3][4] = { { 'D', 'C', 'B', 'A' },{ NULL },{ NULL } };

void hanoi_tower(int n, char from, char tmp, char to);
void hanoi_view();
void hanoi_carry(char from, char to);

int main() {
	puts("\n초기셋팅\n");
	hanoi_view();
	hanoi_tower(4, 'A', 'B', 'C');
	return 0;
}

void hanoi_tower(int n, char from, char tmp, char to) {
	if (n == 1) {
		printf("원판 1을 %c에서 %c로 옮긴다.\n", from, to);
		hanoi_carry(from, to);
		hanoi_view();
	}
	else {
		hanoi_tower(n - 1, from, to, tmp);
		printf("원판 %d을 %c에서 %c로 옮긴다.\n", n, from, to);
		hanoi_carry(from, to);
		hanoi_view();
		hanoi_tower(n - 1, tmp, from, to);
	}
}

void hanoi_carry(char from, char to) {
	int i, first, last, check;
	((from == 'A') ? (first = 0) : (from == 'B') ? (first = 1) : (first = 2));
	((to == 'A') ? (last = 0) : (to == 'B') ? (last = 1) : (last = 2));
	for (i = 0; ; i++) {
		if (target[first][i] == NULL) { check = i - 1;	break; }
	}
	for (i = 0; i<4; i++) {
		if (target[last][i] == NULL) {
			target[last][i] = target[first][check];
			target[first][check] = NULL;
			break;
		}
	}
}

void hanoi_view() {
	int i, j;
	for (i = 3; i >= 0; i--) {
		for (j = 0; j < 3; j++) {
			if (target[j][i] != NULL)	printf("\t%c\t", target[j][i]);
			else printf("\t \t");
		}
		puts("");
	}
	puts("───────────────────────");
	printf("\tA \t\tB \t\tC \n");
	puts("\n");
}
