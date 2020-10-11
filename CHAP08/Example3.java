class QNode{
  char data;
  QNode link;
}

class LinkQueue implements Queue{
  QNode front;
  QNode rear;

  public LinkedQueue(){
    front = null;
    rear = null;
  }

  public boolean isEmpty(){
    return (front == null);
  }

  public void enQueue(char item){
    QNode newNode = new QNode();
    newNode.data = item;
    newNode.link = null;
    if(isEmpty()){
      front = newNode;
      rear = newNode;
    }else{
      rear.link = newNode;
      rear = newNode;
    }
    System.out.println("Inserted Item : " + item);
  }

  public char deQueue(){
    if(isEmpty()){
      System.out.println("Deleting gail! Linked Queue is empty!!");
      return 0;
    }else{
      char item = front.data;
      front = front.link;
      if(front == null) {
        rear = null;
      }
      return item;
    }
  }
}