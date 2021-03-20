import java.util.Random;

public abstract class Thread {
   Method currentMethod;
   private int threadId;
   //static final int nthreads = 10;
   public Thread(int id) {
      threadId = id;
   }
   /* public int getNewThreadId() {
      return threadId++;
   }*/
   public int getThreadId() {
      return threadId;
   }
   public abstract Method nextMethod();
   public abstract String getState();
   public void step(int line) {
      if (currentMethod == null) {
         currentMethod = nextMethod();
         currentMethod.log(line);
      } else {
         currentMethod.step(line);
      }
      if (currentMethod.isCompleted()) {
         currentMethod = null;
      }
   }
   public boolean betweenMethods() {
      return currentMethod == null;
   }
   static void iterate(Thread[] threads) {
      for (int i = 0; i < 10000; i++) {
         for (int j = 0; j < threads.length; j++) {
            threads[j].step(threads.length * i + j);
            if (threads[j].betweenMethods()) {
               System.out.println(threads[j].getState());
	    }
	 }
      }
   }
}
