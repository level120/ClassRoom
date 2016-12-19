/*
	* 단순 연결 리스트 삽입 코드
	* PPT에서는 삽입의 3가지 경우를 알려주는데, 이건 새로운 노드를 앞쪽에 추가하는 방식일 경우에 3가지.
	* 현재 작성된 방법은 새로운 노드를 뒤에 삽입하는 방식.
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
	int data;
	struct Node * Next_node;
}Node;

Node* new_node(int data) {       // 새로운 node를 만드는 함수
	Node * node = (Node *)malloc(sizeof(Node));
	node->data = data;
	node->Next_node = NULL;
	return node;
}

void insert_node(Node** head, Node** insert, Node* node) {   // 삽입 함수
	if ((*head) != NULL) {
		(*insert)->Next_node = node;
		*insert = node;
	}
	else {    // head 값이 NULL인 경우, 맨 첫 리스트에 삽입 또한 선행 노드(여기서는 insert) 값이 NULL인 경우에도 맨 첫 리스트에 삽입
		*head = node;
		*insert = node;
	}
}

int main() {
	int input_data;
	Node * head = NULL;     // head 포인터
	Node * insert = NULL;   // 중간에 삽입할 포인터(ppt의 설명으로는 선행 노드를 가리키는 포인터라 함.)
	
	printf("First node data : ");
	scanf("%d", &input_data);
	
	Node * n1 = new_node(input_data);   // 동적할당으로 새로운 node 생성
	insert_node(&head, &insert, n1);    // 새로운 node에 입력받은 input_data 삽입

	printf("Second node data : ");
	scanf("%d", &input_data);
	
	Node * n2 = new_node(input_data);  // 동적할당으로 새로운 node 생성
	insert_node(&head, &insert, n2);   // 새로운 node에 입력받은 input_data 삽입

	puts("");
	printf("Next list : %x, %x\n", n1->Next_node, n2->Next_node);    // 해당 노드의 next_node값(다음 노드 주소 값) 출력(두번째는 NULL 값인 0이 출력됨.)
	printf("List data : %d, %d\n", n1->data, n2->data);              // 삽입된 데이터 출력
	return 0;
}