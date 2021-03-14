public class Set {
  private Node head;
  Set() {
     Node last = new Node(Character.MAX_VALUE, null);
     head = new Node(Character.MIN_VALUE, last);
  }
  Node getHead() {
    return head;
  }
  public String toString() {
    String s = new String();
    for (Node curr = head; curr != null; curr = curr.getNext()) {
      s += "item=" + curr.getContentsString() + " marked=" + curr.getMarked();
      if (curr.getNext() != null) {
        s += System.lineSeparator();
      }
    }
    return s;
  }
}
