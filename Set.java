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
      if (curr.getContents() == Character.MAX_VALUE) {
	 item = "max sentinel";
      } else if (curr.getContents() == Character.MIN_VALUE) {
	 item = "min sentinel";
      } else {
	 item = String.valueOf(curr.getContents());
      }
      System.out.println("item=" + item);
      System.out.println("marked=" + curr.getMarked());
    }
  }
}
