/*
	* �ܼ� ���� ����Ʈ ���� �ڵ�
	* PPT������ ������ 3���� ��츦 �˷��ִµ�, �̰� ���ο� ��带 ���ʿ� �߰��ϴ� ����� ��쿡 3����.
	* ���� �ۼ��� ����� ���ο� ��带 �ڿ� �����ϴ� ���.
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
	int data;
	struct Node * Next_node;
}Node;

Node* new_node(int data) {       // ���ο� node�� ����� �Լ�
	Node * node = (Node *)malloc(sizeof(Node));
	node->data = data;
	node->Next_node = NULL;
	return node;
}

void insert_node(Node** head, Node** insert, Node* node) {   // ���� �Լ�
	if ((*head) != NULL) {
		(*insert)->Next_node = node;
		*insert = node;
	}
	else {    // head ���� NULL�� ���, �� ù ����Ʈ�� ���� ���� ���� ���(���⼭�� insert) ���� NULL�� ��쿡�� �� ù ����Ʈ�� ����
		*head = node;
		*insert = node;
	}
}

int main() {
	int input_data;
	Node * head = NULL;     // head ������
	Node * insert = NULL;   // �߰��� ������ ������(ppt�� �������δ� ���� ��带 ����Ű�� �����Ͷ� ��.)
	
	printf("First node data : ");
	scanf("%d", &input_data);
	
	Node * n1 = new_node(input_data);   // �����Ҵ����� ���ο� node ����
	insert_node(&head, &insert, n1);    // ���ο� node�� �Է¹��� input_data ����

	printf("Second node data : ");
	scanf("%d", &input_data);
	
	Node * n2 = new_node(input_data);  // �����Ҵ����� ���ο� node ����
	insert_node(&head, &insert, n2);   // ���ο� node�� �Է¹��� input_data ����

	puts("");
	printf("Next list : %x, %x\n", n1->Next_node, n2->Next_node);    // �ش� ����� next_node��(���� ��� �ּ� ��) ���(�ι�°�� NULL ���� 0�� ��µ�.)
	printf("List data : %d, %d\n", n1->data, n2->data);              // ���Ե� ������ ���
	return 0;
}