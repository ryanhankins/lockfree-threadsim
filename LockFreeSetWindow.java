class LockFreeSetWindow {
   public LockFreeSetNode pred;
   public LockFreeSetNode curr;
   LockFreeSetWindow (LockFreeSetNode p, LockFreeSetNode c) {
      pred = p; curr = c;
   }
};
