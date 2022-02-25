#include <iostream>

using namespace std;

class myStack
{
  public:
  int MAX_SIZE;
  int * _STACK;
  int top = -1;
  myStack(int MAX_SIZE)
  {
    this->MAX_SIZE = MAX_SIZE;
    this->_STACK = new int[MAX_SIZE];
  }
  bool isEmpty()
  {
    if (top == -1){return true;}
    else{return false;}
  }
  bool isFull()
  {
    if (top == MAX_SIZE){return true;}
    else{return false;}
  }
  int peek()
  {
    if (!isEmpty())
    {
      return(_STACK[top]);
    }
    else{return(-1);}
  }
  int pop()
  {
    int r;
    if (!isEmpty())
    {
      r = _STACK[top];
      top -= 1;
      return(r);
    }
    else{cout << "Empty" << endl;return(-1);}
  }
  void push(int d)
  {
    if (!isFull())
    {
      top += 1;
      _STACK[top] = d;
    }
    else{cout << "Full" << endl;}
  }
};

int main() 
{
  myStack testStack = myStack(10);
  testStack.push(3);
  cout << testStack.peek() << endl;
  testStack.push(4);
  testStack.push(54);
  cout << testStack.peek() << endl;
  cout << testStack.pop() << endl;
  cout << testStack.peek() << endl;
  for (int x = 0; x <= 8; x++)
  {
    testStack.push(x);
  }
  cout << testStack.peek() << endl;
  testStack.push(11);
  cout << testStack.pop() << endl;
  return 0;
}