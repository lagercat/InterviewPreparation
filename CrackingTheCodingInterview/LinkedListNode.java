public class LinkedListNode<T> {
  private T key;
  private LinkedListNode<T> next;

  public LinkedListNode(T key) {
    this.key = key;
    next = null;
  }

  public T getKey() {
      return key;
  }

  public void setKey(T key) {
    this.key = key;
  }

  public LinkedListNode<T> getNext() {
    return next;
  }

  public void setNext(LinkedListNode<T> next) {
    this.next = next;
  }
}
