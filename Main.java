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
   }
};
