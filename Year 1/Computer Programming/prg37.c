/*WAp to creat a linked list allong with a:-
 * a) Function to insert a node as the last node of the list.
 * b) Function to delete the first node.
 * c) Function to search a node in a Linked List
 */
#include <stdio.h>
#include <stdlib.h>

struct node {
	int data;
	struct node* next;
};

struct Linklist {
	struct node* START;
	struct node* END;
	int size;
};

struct Linklist create(struct Linklist l) {
	l.START = NULL;
	l.END = NULL;

	printf("Created new Linked List\n");
	return l;
}

struct Linklist insertList(int num, struct Linklist l) {
	struct node* newNode;
	newNode = malloc(sizeof(struct node));
	/*New node is null*/
	newNode->data = num;
	newNode->next = NULL;

	/*This is when first node is inserted*/
	if (l.START == NULL) {
		l.START = newNode;
		l.END = newNode;
	}
	else {
		l.END->next = newNode;
		l.END = newNode;
	}

	printf("Inserted %d in Linked List\n", num);
	return l;
}

void printList(struct Linklist l) {
	struct node* temp;
	temp = l.START;

	printf("Printing the Linked List:\n");
	while (temp) {
		printf("%d\n", temp->data);
		temp = temp->next;
	}
}

void removeList(struct Linklist l) {
	struct node* p, * temp;
	p = l.START;
	while (p) {
		temp = p->next;
		free(p);
		p = temp;
	}
	printf("Cleared Linked list\n");
}

void main() {
	struct Linklist L;
	printf("Welcome to Linked List Program\n");
	printf("\n");
	L = create(L); /*Initializtion of list(Pass by Value)*/

	printf("\n");
	L = insertList(16, L);
	L = insertList(17, L);
	L = insertList(18, L);
	L = insertList(19, L);

	printf("\n");
	printList(L);

	printf("\n");
	removeList(L);
}
