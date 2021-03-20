public class LockFreeSetNode {
   private char contents;
   private LockFreeSetNode next;
   private boolean marked;
   LockFreeSetNode(char c, LockFreeSetNode n) {
      contents = c;
      next = n;
   }
   LockFreeSetNode getNext() {
      return next;
   }
   void setNext(LockFreeSetNode n) {
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
