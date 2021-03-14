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
   String getContentsString() {
      if (contents == Character.MAX_VALUE) {
         return "max";
      } else if (contents == Character.MIN_VALUE) {
         return "min";
      }
      return String.valueOf(contents);
   }
   String getMarkedString() {
      return marked ? "true" : "false";
   }
}
