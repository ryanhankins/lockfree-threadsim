public class LockFreeSetAdd extends Method {
   private int pc = 0;
   private LockFreeSetNode pred = null, curr = null;
   LockFreeSetFind f;
   LockFreeSetWindow window;
   boolean returnValue = false;
   private LockFreeSetNode head;
   private char item;
   LockFreeSetAdd(LockFreeSetNode h, char i, int t) {
      super(t);
      head = h;
      item = i;
   }
   public String getName() {
      return "Add";
   }
   public String getArgStr() {
      return String.valueOf(item);
   }
   public void step() {
      switch(pc) {
         case 0:
         log("Invoking Find(head, " + item + ")");
         f = new LockFreeSetFind(head, item, threadId);
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
         if (curr.getContents() == item) {
            log("curr.getContents(" + curr.getContentsString() + ") == item " + item + " is true");
            log("returning false");
            returnValue = false;
            completed = true;
         } else {
            log("curr.getContents(" + curr.getContentsString() + ") == item " + item + " is false");
         }
         pc++;
         break;

         case 5:
         LockFreeSetNode node = new LockFreeSetNode(item, curr);
         if(pred.getNext() == curr && pred.getMarked() == false) {
            log("pred.getNext(" + pred.getNext().getContentsString() + ") == curr && pred.getMarked() == false is true");
            returnValue = true;
            log("pred.setNext(node)");
            pred.setNext(node);
            log("returning true");
            completed = true;
         } else {
            log("pred.getNext(" + pred.getNext().getContentsString() + ") == curr " + curr.getContentsString() + " && pred.getMarked(" + pred.getMarkedString() + ") == false is false");
         }
         pc = 0;
         break;
      }
   }
   public boolean getReturnStatus() {
      return returnValue;
   }
};
