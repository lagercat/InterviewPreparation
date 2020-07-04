public class KthLast {

  public static <T> LinkedListNode<T> kthLast(LinkedListNode<T> list, int k) {
    assert k > 0;
    assert list != null;

    LinkedListNode<T> i, j;
    int idx_j = 0;
    j = list;

    while (j.getNext() != null && idx_j < k - 1) {
      j = j.getNext();
      idx_j++;
    }

    if (idx_j != k - 1) {
      throw new IllegalArgumentException("The given list contains less than k elements");
    }

    i = list;
    while (j.getNext() != null) {
      i = i.getNext();
      j = j.getNext();
    }

    return i;
  }

  public static void main(String[] args) {

    // Create the list 1 -> 4 -> -1 -> -2 -> 9
    LinkedListNode<Integer> list = new LinkedListNode<>(1);
    list.setNext(new LinkedListNode<>(4));
    list.getNext().setNext(new LinkedListNode<>(-1));
    list.getNext().getNext().setNext(new LinkedListNode<>(-2));
    list.getNext().getNext().getNext().setNext(new LinkedListNode<>(9));

    System.out.println(kthLast(list, 5).getKey());
    System.out.println(kthLast(list, 3).getKey());
    System.out.println(kthLast(list, 4).getKey());
    System.out.println(kthLast(list, 6).getKey());
  }
}
