public class MCSLock {
  private MCSLockQNode tail;
  MCSLock() {
    tail = null;
  }
  MCSLockQNode getTail() {
    return tail;
  }
  void setTail(MCSLockQNode t) {
    tail = t;
  }
  /*
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
  */
}
