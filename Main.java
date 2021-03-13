public class Main {
   static final int nthreads = 10;
   public static void main(String args[]) {
      Set s = new Set();
      Thread threads[] = new Thread[nthreads];
      for (int i = 0; i < nthreads; i++) {
         threads[i] = new Thread(s.getHead(), i);
      }
      for (int i = 0; i < 1000; i++) {
	 for (int j = 0; j < nthreads; j++) {
            threads[j].step();
	    if (threads[j].betweenMethods()) {
               s.Print();
	    }
	 }
      }
      s.Print();

      /*
      System.out.println("Contains x");
      Contains c = new Contains(s.getHead(), 'x');
      while(!c.isCompleted()) {
         c.step();
      }
      System.out.println("Add x");
      Add a = new Add(s.getHead(), 'x');
      while(!a.isCompleted()) {
	a.step();
      }
      s.Print();
      System.out.println("Contains x");
      c = new Contains(s.getHead(), 'x');
      while(!c.isCompleted()) {
         c.step();
      }
      System.out.println("Remove x");
      Remove r = new Remove(s.getHead(), 'x');
      while(!r.isCompleted()) {
         r.step();
      }
      System.out.println("Contains x");
      c = new Contains(s.getHead(), 'x');
      while(!c.isCompleted()) {
         c.step();
      }
      */
   }
};
