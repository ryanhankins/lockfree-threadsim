public class Main {
   static final int nthreads = 10;
   public static void main(String args[]) {
      Set s = new Set();
      Thread threads[] = new Thread[nthreads];
      for (int i = 0; i < nthreads; i++) {
         threads[i] = new Thread(s.getHead(), i);
      }
      for (int i = 0; i < 10000; i++) {
	 for (int j = 0; j < nthreads; j++) {
            threads[j].step(nthreads * i + j);
	    if (threads[j].betweenMethods()) {
               System.out.println(s);
	    }
	 }
      }
      System.out.println(s);
   }
};
