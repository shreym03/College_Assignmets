/*WAp to creat a linked list allong with a:-
 * a) Function to insert a node as the last node of the list.
 * b) Function to delete the first node.
 * c) Function to search a node in a Linked List
 */
#include<stdio.h>
#include <stdlib.h>
struct node
{
	int data;
	struct node *next;
};
struct Linklist
{
	struct node *START;
	struct node *END;
	int size;
};

struct Linklist create(struct Linklist l)
{
	l.START=NULL;
	l.END=NULL;
	return l;
}

struct Linklist insert(int num,struct Linklist l)
{
	struct node *last;
	struct node *new=(struct node *)malloc(sizeof(struct node));
	/*New node is null*/
	new.data=num;
	new.next=NULL;
	if(l.START==NULL)
	/*This is when first node is inserted*/
	{
		l.START=new;
		l.END=new;
	}
	else
	{
		l.END->next=new;
		l.END=newnode;
	}
	return l;
}
void print(struct Linklist L)
{
	
	
	
main()
{
	int x=16;
	struct Linklist L;
	L=create(L) /*Initializtion of list(Pass by Value)*/
	L=insert(x,L);
}
