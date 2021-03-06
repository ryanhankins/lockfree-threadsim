public class LockFreeSetContains extends Method {
   private int pc = 0;
   private LockFreeSetNode curr = null, succ = null;
   boolean returnValue = false;
   boolean marked;
   private LockFreeSetNode head;
   private char item;
   LockFreeSetContains(LockFreeSetNode h, char i, int t) {
      super(t);
      head = h;
      item = i;
   }
   public String getName() {
      return "Contains";
   }
   public String getArgStr() {
      return String.valueOf(item);
   }
   public void step() {
      switch(pc) {
         case 0:
         log("curr = head");
         curr = head;
	 pc++;
	 break;

	 case 1:
	 if (curr.getContents() < item) {
            log("curr.getContents(" + curr.getContentsString() + ") < item " + item +" is true");
            curr = curr.getNext();
            log("curr = curr.getNext()");
	 } else {
            log("curr.getContents(" + curr.getContentsString() + ") < item " + item +" is false");
	    pc++;
	 }
	 break;

	 case 2:
	 log("succ = curr.next.get(marked);");
	 succ = curr.getNext();
	 marked = curr.getMarked();
	 pc++;
	 break;

	 case 3:
	 if(curr.getContents() == item && !marked) {
	    log("curr.key == key " + item + " && !marked[i] is true");
	    log("returning true");
            returnValue = true;
	 } else {
	    log("curr.key == key " + item + " && !marked[i] is false");
	    log("returning false");
            returnValue = false;
	 }
	 completed = true;
	 pc++;
	 break;
      }
   }
   public boolean getReturnStatus() {
      return returnValue;
   }
};
