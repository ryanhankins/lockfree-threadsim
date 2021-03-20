import java.util.Random;

public class LockFreeSetThread extends Thread {
   static LockFreeSet s = new LockFreeSet();
   Random rand = new Random();
   char currentArgument;
   public LockFreeSetThread(int id) {
      super(id);
   }
   public Method nextMethod() {
      Method m = null;
      currentArgument = (char)(rand.nextInt(26) + 'a');
      switch(rand.nextInt(3)) {
         case 0:
         m = new LockFreeSetAdd(s.getHead(), currentArgument, getThreadId());
         break;

         case 1:
         m = new LockFreeSetRemove(s.getHead(), currentArgument, getThreadId());
         break;

         case 2:
         m = new LockFreeSetContains(s.getHead(), currentArgument, getThreadId());
         break;

         case 3:
         System.out.println("no method found");
      }
      return m;
   }
   public boolean betweenMethods() {
      return currentMethod == null;
   }
   public String getState() {
      return s.toString();
   }
   public static void main(String args[]) {
      LockFreeSetThread threads[] = new LockFreeSetThread[10];
      for (int i = 0; i < threads.length; i++) {
         threads[i] = new LockFreeSetThread(i);
      }
      iterate(threads);
      System.out.println(s);
   }
}
