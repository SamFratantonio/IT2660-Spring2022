#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

struct lNode {
   int data;
   struct lNode *next;
  lNode(){}
  lNode(int d){
    data = d;
  }
  void insertAfter(int data){
    lNode *rest = next->next;
    next = new lNode(data);
    next->next = rest;
  }
};

struct linkList {
  lNode *front = NULL;
  linkList(){}
  linkList(int data){
    front->data = data;
  }
  lNode *delFirst(){
    lNode *temp = front;
    front = front->next;
    return(temp);
  }
  void addFirst(int data){
    if (front == NULL){
      front = new lNode(data);
    } else {
      lNode *temp = front;
      front = new lNode(data);
      front->next = temp;
    }
  }
  void addLast(int data){
    lNode *temp = front;
    do {temp = temp->next;}while(temp->next != NULL);
    temp->next = new lNode(data);
  }
  void showAll(){
    lNode *temp = front;
    int i = 0;
    while(temp != NULL) {
      std::cout << "Index: " << i << " Data: " << temp->data << std::endl;
      temp = temp->next;
      i++;
    }
    std::cout << std::endl;
  }
  void insertAt(int target, int data){
    lNode *temp = front;
    if (target==0){
      addFirst(data);
    } else {
      int i = 0;
      for (int x = 0; x < target-1; x++){
        temp = temp->next;
      }
      temp->insertAfter(data);
    }
  }
};

int main() {
  linkList links;
  links.addFirst(23);
  links.addFirst(34);
  links.addFirst(45);
  links.addFirst(39);
  links.addFirst(54);
  links.showAll();
  links.insertAt(3, 67);
  links.showAll();
  links.addLast(420);
  links.showAll();
  return(0);
}