public class Set {
  private Node head;
  Set() {
     Node last = new Node(Character.MAX_VALUE, null);
     head = new Node(Character.MIN_VALUE, last);
  }
  Node getHead() {
    return head;
  }
  void Print() {
    String item;
    for (Node curr = head; curr != null; curr = curr.getNext()) {
      System.out.println("item=" + curr.getContentsString() + " marked=" + curr.getMarked());
    }
  }
}
