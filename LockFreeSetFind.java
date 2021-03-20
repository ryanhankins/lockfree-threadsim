public class LockFreeSetFind extends Method {
   private int pc = 0;
   private LockFreeSetNode pred = null, curr = null, succ = null;
   boolean marked;
   LockFreeSetWindow returnValue;
   private LockFreeSetNode head;
   Character item;
   LockFreeSetFind(LockFreeSetNode h, char i, int t) {
      super(t);
      head = h;
      item = i;
   }
   public String getName() {
      return "Find";
   }
   public int getIndent() {
      return 2;
   }
   public String getArgStr() {
      return String.valueOf(item);
   }
   public void step() {
      switch(pc) {
         case 0:
         log("pred = head");
         pred = head;
	 pc++;
	 break;

	 case 1:
         curr = pred.getNext();
         log("curr " + curr.getContentsString() + " = pred.getNext(" + pred.getContentsString() + ");");
	 pc++;
	 break;
         
	 case 2:
         succ = curr.getNext();
	 log("succ " + (succ == null ? "null" : succ.getContentsString()) + " = curr.next.get(marked);");
	 marked = curr.getMarked();
	 pc++;
	 break;

	 case 3:
         if(marked) {
	    log("if(marked) is true");
            if(pred.getNext() == curr &&
               pred.getMarked() == false) {
               pred.setNext(succ);
               log("pred.next.compareAndSet(curr, succ, false, false) returns true");

	       pc++;
	    } else {
               log("pred.next.compareAndSet(curr, succ, false, false) returns false");
               pc = 0;
	    }
	 } else {
	    log("if(marked) is false");
            pc = 6;
	 }
	 break;

	 case 4:
	 log("curr = succ");
	 curr = succ;
	 pc++;
	 break;

	 case 5:
	 log("succ = curr.next.get(marked)");
	 succ = curr.getNext();
	 marked = curr.getMarked();
	 pc = 3;
	 break;

	 case 6:
	 if (curr.getContents() >= item) {
	    log("curr.getContents(" + curr.getContentsString() + ") >= item " + item + " is true");
	    returnValue = new LockFreeSetWindow(pred, curr);
	    log("returning pred=" + returnValue.pred.getContentsString() + " curr=" + returnValue.curr.getContentsString());
	    completed = true;
	 } else {
	   log("curr.getContents(" + curr.getContentsString() + ") >= item " + item + " is false");
	   pc++;
	 }
	 break;

	 case 7:
	 log("pred = curr");
	 pred = curr;
	 pc++;
	 break;
	 
	 case 8:
	 log("curr = succ");
	 curr = succ;
	 pc = 2;
	 break;

      }
   }
   LockFreeSetWindow getReturnStatus() {
      return returnValue;
   }
};
