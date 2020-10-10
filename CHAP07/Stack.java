interface Stack {
  boolean isEmpty();
  void push(char item);
  char pop();
  void delete();
  char peek();
}
class StackNode {
  char data;
  StackNode link;
}
