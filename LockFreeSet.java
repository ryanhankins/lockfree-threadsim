public class LockFreeSet {
  private LockFreeSetNode head;
  LockFreeSet() {
     LockFreeSetNode last = new LockFreeSetNode(Character.MAX_VALUE, null);
     head = new LockFreeSetNode(Character.MIN_VALUE, last);
  }
  LockFreeSetNode getHead() {
    return head;
  }
  public String toString() {
    String s = new String();
    for (LockFreeSetNode curr = head; curr != null; curr = curr.getNext()) {
      s += "item=" + curr.getContentsString() + " marked=" + curr.getMarked();
      if (curr.getNext() != null) {
        s += System.lineSeparator();
      }
    }
    return s;
  }
}
