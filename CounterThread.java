import java.util.Random;

public class CounterThread extends Thread {
   static Counter c = new Counter();
   Random rand = new Random();
   public CounterThread(int id) {
      super(id);
   }
   public Method nextMethod() {
      if(rand.nextInt(2) == 0) {
         return new CounterGetAndIncrement(c, getThreadId());
      } else {
         return new Sleep(rand.nextInt(3), getThreadId());
      }

   }
   public boolean betweenMethods() {
      return currentMethod == null;
   }
   public String getState() {
	   return "counter=" + c.value;
   }
   public static void main(String args[]) {
      CounterThread threads[] = new CounterThread[5];
      for (int i = 0; i < threads.length; i++) {
         threads[i] = new CounterThread(i);
      }
      iterate(threads);
      //System.out.println(s);
   }
}
