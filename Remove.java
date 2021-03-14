public class Remove extends Method {
   private int pc = 0;
   private Node pred = null, curr = null, succ = null;
   Find f;
   Window window;
   boolean returnValue = false;
   private Node head;
   private char item;
   Remove(Node h, char i, int t) {
      super(t);
      head = h;
      item = i;
   }
   public String getName() {
      return "Remove";
   }
   public String getArgStr() {
      return String.valueOf(item);
   }
   public void step() {
      switch(pc) {
         case 0:
         log("Invoking Find(head, " + item + ")");
         f = new Find(head, item, threadId);
	 pc++;
	 break;

	 case 1:
         if(!f.isCompleted()) {
            f.step(getLine());
         } else {
	   window = f.getReturnStatus();
	   pc++;
	 }
	 break;

	 case 2:
	 log("pred = window.pred");
	 pred = window.pred;
	 pc++;
	 break;

	 case 3:
	 log("curr = window.curr");
	 curr = window.curr;
	 pc++;
	 break;

	 case 4:
	 if (curr.getContents() != item) {
            log("curr.getContents() != item " + item + " is true");
	    log("returning false");
            returnValue = false;
	    completed = true;
	 } else {
            log("curr.getContents() != item " + item + " is false");
	 }
	 pc++;
	 break;

	 case 5:
	 log("succ = curr.getNext()");
	 succ = curr.getNext();
	 pc++;
	 break;

	 case 6:
	 if(curr.getNext() == succ && curr.getMarked() == false) {
            log("curr.getNext() == succ && curr.getMarked() == false is true");
            curr.setMarked(true);
	    log("curr.setMarked(true)");
	    pc++;
	 } else {
            log("curr.getNext() == succ && curr.getMarked() == false is false");
            pc = 0;
	 }
	 break;

	 case 7:
	 if(pred.getNext() == curr && pred.getMarked() == false) {
            log("pred.getNext() == curr && pred.getMarked() == false is true");
	    log("pred.setNext(succ)");
            pred.setNext(succ);
	 } else {
            log("pred.getNext() == curr && pred.getMarked() == false is false");
	 }
	 pc++;
	 break;

	 case 8:
	 log("returning true");
	 returnValue = true;
	 completed = true;
	 break;
      }
   }
   public boolean getReturnStatus() {
      return returnValue;
   }
};
