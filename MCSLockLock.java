class MCSLockLock extends Method {
   int pc;
   MCSLockQNode myNode;
   MCSLock lock;
   MCSLockQNode qnode;
   MCSLockQNode pred;
   MCSLockLock(MCSLock l, MCSLockQNode q, int thread) {
      super(thread);
      myNode = q;
      lock = l;
   }
   public void step() {
      switch(pc) {
         case 0:
         qnode = myNode;
         log("qnode " + qnode + " = myNode");
         pc++;
         break;

         case 1:
         pred = lock.getTail();
         lock.setTail(qnode);
         log("pred " + pred + " = tail.getAndSet(qnode)");
         pc++;
         break;

         case 2:
         if (pred != null) {
            log("pred != null");
            log("qnode.locked = true");
            qnode.locked = true;
            log("pred.next = qnode");
            pred.next = qnode;
         } else {
           log("pred == null");
         }
         pc++;
         break;

         case 3:
         if (qnode.locked == false) {
           log("qnode.locked == false");
           completed = true;
         } else {
           log("qnode.locked == true");
         }
         break;
      }
   }
   public String getName() {
      return "Lock";
   }
   public MCSLockQNode getQNode() {
    return qnode;
   }
}
