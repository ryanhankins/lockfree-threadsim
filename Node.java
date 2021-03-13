public class Node {
   private char contents;
   private Node next;
   private boolean marked;
   Node(char c, Node n) {
      contents = c;
      next = n;
   }
   Node getNext() {
      return next;
   }
   void setNext(Node n) {
      next = n;
   }
   boolean getMarked() {
      return marked;
   }
   void setMarked(boolean m) {
      marked = m;
   }
   char getContents() {
      return contents;
   }
}