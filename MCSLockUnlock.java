class MCSLockUnlock extends Method {
   int pc = 0;
   MCSLock lock;
   MCSLockQNode myNode;
   MCSLockQNode qnode;
   MCSLockQNode pred;
   boolean hasSuccessor;
   MCSLockUnlock(MCSLock l, MCSLockQNode q, int thread) {
      super(thread);
      myNode = q;
      lock = l;
   }
   public void step() {
      switch(pc) {
         case 0:
         log("qnode = myNode");
         qnode = myNode;
         pc++;
         break;

         case 1:
         if(qnode.next == null) {
           log("qnode.next == null");
           pc++;
         } else {
           log("qnode.next != null");
           pc = 4;
         }
         break;

         case 2:
         if (lock.getTail() == qnode) {
           log("tail == qnode");
           log("tail = null");
           lock.setTail(null);
           completed = true;
         } else {
           log("tail != qnode");
         }
         pc++;
         break;

         case 3:
         if (qnode.next == null) {
           log("qnode.next == null");
         } else {
           log("qnode.next != null");
           pc++;
         }
         break;

         case 4:
         log("qnode.next.locked = false");
         qnode.next.locked = false;
         pc++;
         break;

         case 5:
         log("qnode.next = null");
         qnode.next = null;
         completed = true;
         break;
      }
   }
   public String getName() {
      return "Unlock";
   }
}
