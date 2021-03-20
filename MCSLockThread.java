import java.util.Random;

public class MCSLockThread extends Thread {
   static MCSLock l = new MCSLock();
   Random rand = new Random();
   MCSLockQNode qnode = new MCSLockQNode();
   boolean doLock = true;
   public MCSLockThread(int id) {
      super(id);
   }
   public Method nextMethod() {
      Method m = null;
      if(rand.nextInt(10) > 5) {
        m = new Sleep(rand.nextInt(3), getThreadId());
      } else {
        if(doLock) {
          m = new MCSLockLock(l, qnode, getThreadId());
        } else {
          m = new MCSLockUnlock(l, qnode, getThreadId());
        }
        doLock = !doLock;
      }
      return m;
   }
   public boolean betweenMethods() {
      return currentMethod == null;
   }
   public String getState() {
      return qnode.toString();
   }
   public static void main(String args[]) {
      MCSLockThread threads[] = new MCSLockThread[2];
      for (int i = 0; i < threads.length; i++) {
         threads[i] = new MCSLockThread(i);
      }
      iterate(threads);
      //System.out.println(s);
   }
}
